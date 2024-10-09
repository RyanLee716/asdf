class ReviewRunner {
  public static void main(String[] args) 
  {
    // Make array of the words in the file (with punctuation)
    String reviewText = Review.textToString("SimpleReview.txt");
    String[] textArr = reviewText.split(" ");
    int index = 0;

    // iterate through each word, look for ones with asteriks and replace
    // positive adjectives are replaced with positive ones and vice versa
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
    // print the fake review
    System.out.println(String.join(" ", textArr));
  }
}
