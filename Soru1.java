import java.util.Scanner;
public class Soru1 {
	public static void main(String[] args) {
		Scanner keyboard=new Scanner(System.in);
		String hamle="";
		boolean control=true;
		try {
			 hamle=args[0];			 
			 try {
				for(int i=0;i<hamle.length();i++) {					
					if(hamle.charAt(i)<48||hamle.charAt(i)>57) {						
						throw new Exception();						
					}
				}				 
			} catch (Exception e) {
				System.out.println("programi tekrar baslatiniz giridiginiz input programda calismiyor");
				control=false;
			}				 
		} catch (Exception e) {			
		}		
		Bilgisayar b=new Bilgisayar();
		Oyuncu o=new Oyuncu();
		int whichOne=0;
		while(true&&control) {
			o.kaynakEkleme();
			b.kaynakEkleme();
			System.out.println("1. Oyuncu: "+"Can:"+o.can+" A:"+o.altinMadeni[0].returnNmbr(o.controlAltin)+", T:"+o.tasOcagi[0].returnNmbr(o.controlTas)
					+", O:"+o.odunUretimEvi[0].returnNmbr(o.controlOdun)+", "
					+"a:"+o.altin+", t:"+o.tas+", o:"+o.odun+", Kule:"+o.controlKule+" Kale:"+o.controlKale+", "
					+"piyade:"+o.yariUstuCan(o.piyade,o.piyadeSayisi,10)+", ok�u:"+o.yariUstuCan(o.okcu,o.okcuSayisi,5)+", suvari:"+o.yariUstuCan(o.suvari,o.suvariSayisi,40));
			System.out.println("2. Oyuncu: "+"Can:"+b.can+" A:"+b.altinMadeni[0].returnNmbr(b.controlAltin)+", T:"+b.tasOcagi[0].returnNmbr(b.controlTas)+", O:"
					+b.odunUretimEvi[0].returnNmbr(b.controlOdun)+", "
					+"a:"+b.altin+", t:"+b.tas+", o:"+b.odun+", Kule:"+b.controlKule+" Kale:"+b.controlKale+", "
					+"piyade:"+b.yariUstuCan(b.piyade,b.piyadeSayisi,10)+", ok�u:"+b.yariUstuCan(b.okcu,b.okcuSayisi,5)+", suvari:"+b.yariUstuCan(b.suvari,b.suvariSayisi,40));		
			if(whichOne%2==0) {
				System.out.println("\nSira: 1. oyuncu");
				int hamleSecici=0;
				boolean yapaBildiMi=false;				
				while(!yapaBildiMi) {
					System.out.println("\nYap�lacak hamlenizi se�iniz\r\n"
							+ "0- Pas\r\n"
							+ "1- Altin madeni kurma\r\n"
							+ "2- Ta� oca�� kurma\r\n"
							+ "3- Odun �retim yeri kurma\r\n"
							+ "4- Kule yapma\r\n"
							+ "5- Kale yapma\r\n"
							+ "6- 1 piyade �retme\r\n"
							+ "7- 1 ok�u �retme\r\n"
							+ "8- 1 suvari �retme\r\n"
							+ "9- Sald�r�");
					if(hamle.length()>0) {						
						hamleSecici=Integer.valueOf(hamle.charAt(0)-48);						
						hamle=hamle.substring(1);
					}else {
						hamleSecici=keyboard.nextInt();
					}
					yapaBildiMi=o.doIt(hamleSecici,b,whichOne%2==0);					
					if(yapaBildiMi&&hamleSecici==9) {
						if(b.can==101) {
							System.out.println("Kazand�n�z!");
							control=false;
							break;							
						}						
					}					
					else if(!yapaBildiMi)System.out.println("hamle yapilamiyor tekrar giriniz");
				}			
			}else {
				System.out.println("\nSira: 2. oyuncu");
				b.doItComputer(whichOne, o);				
			}whichOne++;System.out.println();			
		}
	}
}