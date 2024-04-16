

class Slip8_a extends Thread 
{
	
    String text;
    int n;

    Slip8_a(String text, int n) {
        this.text = text;
        this.n = n;
    }
    
    public void run() {
  
    	for(int i=0;i<n;i++)
    	{
    		System.out.println(text);
    	}
    }
    public static void main(String[] args) {
    	Slip8_a t1 = new Slip8_a("COVID19", 10);
    	Slip8_a t2 = new Slip8_a("LOCKDOWN2020", 20);
    	Slip8_a t3 = new Slip8_a("VACCINATED", 30);

        t1.start();
        t2.start();
        t3.start();

    }
}