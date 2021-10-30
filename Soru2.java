public class Soru2 {
	public boolean otomatikOyun(Bilgisayar o,Bilgisayar b,int nmbr,int nmbr2) {			
		o.kaynakEkleme();
		b.kaynakEkleme();
		if(nmbr<=0) {
			System.out.println("1. bilgisayar: "+"Can:"+o.can+" A:"+o.altinMadeni[0].returnNmbr(o.controlAltin)+", T:"+o.tasOcagi[0].returnNmbr(o.controlTas)
					+", O:"+o.odunUretimEvi[0].returnNmbr(o.controlOdun)+", "
					+"a:"+o.altin+", t:"+o.tas+", o:"+o.odun+", Kule:"+o.controlKule+" Kale:"+o.controlKale+", "
					+"piyade:"+o.yariUstuCan(o.piyade,o.piyadeSayisi,10)+", okçu:"+o.yariUstuCan(o.okcu,o.okcuSayisi,5)+", suvari:"+o.yariUstuCan(o.suvari,o.suvariSayisi,40));
			System.out.println("2. bilgisayar: "+"Can:"+b.can+" A:"+b.altinMadeni[0].returnNmbr(b.controlAltin)+", T:"+b.tasOcagi[0].returnNmbr(b.controlTas)+", O:"
					+b.odunUretimEvi[0].returnNmbr(b.controlOdun)+", "
					+"a:"+b.altin+", t:"+b.tas+", o:"+b.odun+", Kule:"+b.controlKule+" Kale:"+b.controlKale+", "
					+"piyade:"+b.yariUstuCan(b.piyade,b.piyadeSayisi,10)+", okçu:"+b.yariUstuCan(b.okcu,b.okcuSayisi,5)+", suvari:"+b.yariUstuCan(b.suvari,b.suvariSayisi,40));
			return true;
		}
		else if(o.doItComputer( nmbr2,b)) {
			if(nmbr%2==0) {
				System.out.println("ilk bilgisayar kazandi");
			}else {
				System.out.println("ikinci bilgisayar kazandi");
			}			
			return true;
		}else {
			nmbr--;
			nmbr2+=2;
			return otomatikOyun(b, o, nmbr, nmbr2);}		
	}
	public static void main(String[] args) {
		Soru2 a=new Soru2();
		Bilgisayar b1=new Bilgisayar();
		Bilgisayar b2=new Bilgisayar();		
		a.otomatikOyun(b1, b2, 4788, 0);//Hocam 10000 hamleli oyun yazdigimda 4789. hamleden sonra stackoverFlow hatsai aldim onun icin sayiyi kisa tutum
	}
}