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
					+"piyade:"+o.yariUstuCan(o.piyade,o.piyadeSayisi,10)+", okçu:"+o.yariUstuCan(o.okcu,o.okcuSayisi,5)+", suvari:"+o.yariUstuCan(o.suvari,o.suvariSayisi,40));
			System.out.println("2. Oyuncu: "+"Can:"+b.can+" A:"+b.altinMadeni[0].returnNmbr(b.controlAltin)+", T:"+b.tasOcagi[0].returnNmbr(b.controlTas)+", O:"
					+b.odunUretimEvi[0].returnNmbr(b.controlOdun)+", "
					+"a:"+b.altin+", t:"+b.tas+", o:"+b.odun+", Kule:"+b.controlKule+" Kale:"+b.controlKale+", "
					+"piyade:"+b.yariUstuCan(b.piyade,b.piyadeSayisi,10)+", okçu:"+b.yariUstuCan(b.okcu,b.okcuSayisi,5)+", suvari:"+b.yariUstuCan(b.suvari,b.suvariSayisi,40));		
			if(whichOne%2==0) {
				System.out.println("\nSira: 1. oyuncu");
				int hamleSecici=0;
				boolean yapaBildiMi=false;				
				while(!yapaBildiMi) {
					System.out.println("\nYapýlacak hamlenizi seçiniz\r\n"
							+ "0- Pas\r\n"
							+ "1- Altin madeni kurma\r\n"
							+ "2- Taþ ocaðý kurma\r\n"
							+ "3- Odun üretim yeri kurma\r\n"
							+ "4- Kule yapma\r\n"
							+ "5- Kale yapma\r\n"
							+ "6- 1 piyade üretme\r\n"
							+ "7- 1 okçu üretme\r\n"
							+ "8- 1 suvari üretme\r\n"
							+ "9- Saldýrý");
					if(hamle.length()>0) {						
						hamleSecici=Integer.valueOf(hamle.charAt(0)-48);						
						hamle=hamle.substring(1);
					}else {
						hamleSecici=keyboard.nextInt();
					}
					yapaBildiMi=o.doIt(hamleSecici,b,whichOne%2==0);					
					if(yapaBildiMi&&hamleSecici==9) {
						if(b.can==101) {
							System.out.println("Kazandýnýz!");
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