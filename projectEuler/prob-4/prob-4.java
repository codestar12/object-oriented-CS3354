class Prob_4{

    public static void main(String[] args){
        int largest = - Integer.MAX_VALUE, i, j, holder;

        for(i = 100; i < 1000; i++){
            for(j = 100; j < 1000; j++){
                holder = i * j;
               if(holder > largest && isPal(holder))
                  largest = holder;
            }
        } 
    
        System.out.println(largest);
                
    }
    
    private static int reverseDigit(int num){
        int newNumber = 0;
        while(num > 0){
            newNumber *= 10;
            newNumber += num % 10;
            num /= 10;
        }
        return newNumber;
    }
    
    public static boolean isPal(int num){
        return num == reverseDigit(num);    
    }
}
