class Solution {
    public String numberToWords(int num) {
         if (num == 0) return "Zero";

        int billion = 1000000000;
        int million = 1000000;
        int thousand = 1000;

        String result = "";

        if (num >= billion) {
            result += onetothou(num / billion) + "Billion ";
            num %= billion;
        }
        if (num >= million) {
            result += onetothou(num / million) + "Million ";
            num %= million;
        }
        if (num >= thousand) {
            result += onetothou(num / thousand) + "Thousand ";
            num %= thousand;
        }
        result += onetothou(num);

        return result.trim();

    }
    private String onetothou(int num) {
        if (num == 0) return "";
        if (num < 20) return belowTwenty[num] + " ";
        if (num < 100) return tens[num / 10] + " " + onetothou(num % 10);
        return belowTwenty[num / 100] + " Hundred " + onetothou(num % 100);
    }

    private static final String[] belowTwenty = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static final String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

}