class problemOneClass{
    public static void main(String[] args){
        int sum = 0, i = 0;
        for(i = 3; i < 1000; i+=3){
            sum += i;
        }
        for(i = 5; i < 1000; i+=5){
            sum += i;
        }
        for(i = 15; i < 1000; i+=15){
            sum -= i;
        }
        System.out.println(sum);
    }
}
        
