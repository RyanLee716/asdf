class ReviewRunner {
  public static void main(String[] args) 
  {
    String reviewText = Review.textToString("SimpleReview.txt");
    String[] textArr = reviewText.split(" ");
    int index = 0;
    for (String word : textArr) {
      if ("*".equals(word.substring(0, 1))) {
        if (Review.sentimentVal(textArr[index]) > 0) {
          String adj = Review.randomPositiveAdj();
          textArr[index] = adj.substring(0, adj.indexOf(','));
        }
        else {
          String adj = Review.randomNegativeAdj();
          textArr[index] = adj.substring(0, adj.indexOf(','));
        }
      }
      index += 1;
    }

    System.out.println(String.join(" ", textArr));
  }
}