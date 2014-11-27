public class PhraseOMatic {
	public static void main(String[] args) {
		String[] wordListOne = {
		"24/7", "multi-Tier", "30,000 feet", "B-to-B",
		"win-win", "frontend", "web-based", "pervasive",
		"smart", "sixsigma", "critical-path", "dynamic",
		"Gantt-chart"};
		
		String[] wordListTwo = {
		"centric","distributed","clustered","branded",
		"outside-the-box","positioned","networked","focused",
		"leveraged","aligned","targeted","shared",
		"cooperative","accelerated", "trend"};
		
		String[] wordListThree = {
		"process", "tippingpoint", "solution", "architecture", 
		"core competency", "strategy", "mindshare", "portal", 
		"space", "vision", "paradigm", "mission",
		"operation"};

		int oneLength = wordListOne.length;
		int twoLength = wordListTwo.length;
		int threeLength = wordListThree.length;
		
		int rand1 = (int)(Math.random() * oneLength);
		int rand2 = (int)(Math.random() * twoLength);
		int rand3 = (int)(Math.random() * threeLength);

		String phrase = wordListOne[rand1] + " " + wordListTwo[rand2] + " " + wordListThree[rand3];
		
		System.out.println("What we need is a " + phrase);
	}
}