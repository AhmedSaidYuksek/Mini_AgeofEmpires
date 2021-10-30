public class Oyuncu {
	int can=100;
	int tas=5;
	int altin=1;
	int odun=10;	
	boolean controlAltin=true;
	boolean controlTas=true;
	boolean controlOdun=true;
	int controlKale=0;
	int controlKule=0;
	
	
	AltinMadeni[] altinMadeni=new AltinMadeni[2];
	TasOcagi[] tasOcagi=new TasOcagi[2];
	OdunUretimEvi[] odunUretimEvi=new OdunUretimEvi[2];
	Kale[] kale=new Kale[2];
	Kule[] kule=new Kule[2];
	
	Okcu[] okcu=new Okcu[10];
	Suvari[] suvari=new Suvari[10];
	Piyade[] piyade=new Piyade[10];
	int okcuSayisi=0;
	int suvariSayisi=0;
	int piyadeSayisi=0;
		
	
	public Oyuncu() {
		altinMadeni[0]=new AltinMadeni();
		tasOcagi[0]=new TasOcagi();
		odunUretimEvi[0]=new OdunUretimEvi();
		kale[0]=null;
		kale[1]=null;
		kule[0]=null;
		kule[1]=null;
	}
	public void kaynakEkleme() {
		if(controlAltin)
			altin+=altinMadeni[0].eklenecekDeger;
		else
			altin+=2*altinMadeni[0].eklenecekDeger;
		if(controlTas)
			tas+=tasOcagi[0].eklenecekDeger;
		else
			tas+=2*tasOcagi[0].eklenecekDeger;
		if(controlOdun)
			odun+=odunUretimEvi[0].eklenecekDeger;
		else
			odun+=2*odunUretimEvi[0].eklenecekDeger;
	}
	public int yariUstuCan(Asker[] asker,int askerSayisi,int can) {
		int returnValue=0;
		for(int i=0;i<askerSayisi;i++) {
			if(asker[i].can>(can/2)) {
				returnValue++;
			}
		}return returnValue;
	}
	public boolean doIt(int whichOne,Oyuncu player ,boolean control) {			
		switch (whichOne) {
		case 0:  System.out.println("pas"); return true;
		case 1: {
			if(controlAltin&&altinMadeni[0].isProducible(odun, tas,this)) {
				if(control)System.out.println("<<1 (Oyuncu altin madeni yapmayi seçti)");
				else System.out.println("<<1 (bilgisayar altin madeni yapmayi seçti)");
				altinMadeni[1]=new AltinMadeni();
				controlAltin=false;
				return true;
			}return false;		
		}
		case 2: {
			if(controlTas&&tasOcagi[0].isProducible(odun, tas,this)) {
				if(control)System.out.println("<<2 (Oyuncu tas ocagi yapmayi seçti)");
				else System.out.println("<<2 (bilgisyar tas ocagi yapmayi seçti)");
				tasOcagi[1]=new TasOcagi();
				
				controlTas=false;
				return true;
			}return false;		
		}
		case 3: {
			if(controlOdun&&odunUretimEvi[0].isProducible(odun,this)) {
				if(control)System.out.println("<<3 (Oyuncu odun uretim evi yapmayi seçti)");
				else System.out.println("<<3 (bilgisyar odun uretim evi yapmayi seçti)");
				odunUretimEvi[1]=new OdunUretimEvi();
				controlOdun=false;
				return true;
			}return false;		
		}
		case 4: {
			if(controlKule!=2&&altin>=1&&odun>=5&&tas>=20) {
				if(control)System.out.println("<<4 (Oyuncu kule yapmayi seçti)");
				else System.out.println("<<4 (bilgisayar kule yapmayi seçti)");
				kule[controlKule]=new Kule();
				controlKule++;
				return true;
			}return false;	
		}
		case 5: {
			if(controlKale!=2&&altin>=5&&odun>=15&&tas>=40) {
				if(control)System.out.println("<<5 (Oyuncu kale yapmayi seçti)");
				else System.out.println("<<5 (bilgisayar kale yapmayi seçti)");
				kale[controlKale]=new Kale();
				controlKale++;
				return true;
			}return false;	
		}
		case 8: {
			if(altin>=1&&odun>=2) {
				if(control)System.out.println("<<8 (Oyuncu suvari yapmayi seçti)");
				else System.out.println("<<8 (bilgisayar suvari yapmayi seçti)");
				if(suvariSayisi<suvari.length) {
					suvari[suvariSayisi]=new Suvari();
					suvariSayisi++;
				}else {
					Suvari[] suvari2=new Suvari[suvariSayisi*2];
					for(int i=0;i<suvariSayisi;i++) {
						suvari2[i]=suvari[i];
					}
					suvari=suvari2;
					suvari[suvariSayisi]=new Suvari();
					suvariSayisi++;
				}				
				return true;
			}return false;		
		}
		case 7: {
			if(altin>=1&&odun>=5) {
				if(control)System.out.println("<<7 (Oyuncu okcu yapmayi seçti)");
				else System.out.println("<<7 (bilgisayar okcu yapmayi seçti)");
				if(okcuSayisi<okcu.length) {
					okcu[okcuSayisi]=new Okcu();
					okcuSayisi++;
				}else {
					Okcu[] okcu2=new Okcu[okcuSayisi*2];
					for(int i=0;i<okcuSayisi;i++) {
						okcu2[i]=okcu[i];
					}
					okcu=okcu2;
					okcu[okcuSayisi]=new Okcu();
					okcuSayisi++;
				}				
				return true;
			}return false;			
		}
		case 6: {
			if(altin>=2&&odun>=2) {
				if(control)System.out.println("<<6 (Oyuncu piayde yapmayi seçti");
				else System.out.println("<<6 (bilgisayar piayde yapmayi seçti)");
				if(piyadeSayisi<piyade.length) {
					piyade[piyadeSayisi]=new Piyade();
					piyadeSayisi++;
				}else {
					Piyade[] piyade2=new Piyade[piyadeSayisi*2];
					for(int i=0;i<piyadeSayisi;i++) {
						piyade2[i]=piyade[i];
					}
					piyade=piyade2;
					piyade[piyadeSayisi]=new Piyade();
					piyadeSayisi++;
				}				
				return true;
			}return false;		
		}
		default:if(control)System.out.println("<<9 (Oyuncu saldiriyi seçti)");
		if((okcuSayisi+suvariSayisi+piyadeSayisi)>0){
			if(play(player)==101)return true;			
		}return false;
			
		}		
	}
	public boolean saldir() {
		
		return false;
	}
	public int Sorting(Asker[] asker,int nmbr) {
		for(int i=0;i<nmbr-1;i++) {
			for(int j=0;j<nmbr-1;j++) {
				
				if(asker[j].can>asker[j+1].can) {
					
					int forNow=asker[j].can;
					asker[j].can=asker[j+1].can;
					asker[j+1].can=forNow;
				}
			}
		}		return delete(asker, nmbr);
	}
	
	public int delete(Asker [] asker,int nmbr) {
		int i=0;
		for(;i<nmbr;i++) {
			if(asker[i].can!=0) {				
				break;
			}
				
		}
		for(int j=0;j<nmbr;j++) {
			if(j<nmbr-i)
				asker[j]=asker[j+i];
			else
				asker[j]=null;
		}return nmbr-=i;
	}
	public void sortingBina(SavunmaBinasi[] bina,int nmbr) {
		
		if(nmbr==0) {
			bina[0]=null;
			bina[1]=null;
			
		}
		else if(nmbr==1) {
			if(bina[1]!=null) {
				bina[0]=bina[1];
				bina[1]=null;				
			}
		}
		else {
			if(bina[0].can>bina[1].can) {
				SavunmaBinasi forNow=bina[0];
				bina[0]=bina[1];
				bina[1]=forNow;
			}			
		}
	}
	public int saldirmaKuvveti(Asker[] asker,int askerSayisi) {	
		int returner=0;
		for(int i=0;i<askerSayisi;i++ ) {
			returner+=asker[i].vurus;
		}
		return returner;
	}
	public int saldirBina(Oyuncu player,Asker[] asker,int askerSayisi,boolean okcu) {
		int saldiriGucu=0;		
		if(askerSayisi>0) {
			saldiriGucu=saldirmaKuvveti(asker, askerSayisi);
		}
		if(player.controlKule>0) {
			int nmbr=player.controlKule;			
			for(int i=0;i<nmbr;i++) {
				if(saldiriGucu>=player.kule[i].can) {
					saldiriGucu-=player.kule[i].can;
					player.kule[i].can=0;					
					if(okcu)
						player.kule[i].vurus=0;
					
				}else{
					player.kule[i].can-=saldiriGucu;					
					saldiriGucu=0;
					return 0;
				}
			}
		}if(player.controlKale>0) {
			int nmbr=player.controlKale;
			for(int i=0;i<nmbr;i++) {	
				if(saldiriGucu>=player.kale[i].can) {
					saldiriGucu-=player.kale[i].can;
					if(okcu)
						player.kule[i].vurus=0;					
					player.kale[i].can=0;				
				}else{
					player.kale[i].can-=saldiriGucu;	
					saldiriGucu=0;				
					return 0;
				}
			}
		}return saldiriGucu;
	}
	public void gucYukleme() {
		for(int i=0;i<okcuSayisi;i++) {
			okcu[i].vurus=8;
		}
		for(int i=0;i<piyadeSayisi;i++) {
			piyade[i].vurus=10;
		}
		for(int i=0;i<suvariSayisi;i++) {
			suvari[i].vurus=40;
		}		
	}
	public void KuleKaleSavunma(SavunmaBinasi[] bina,int binasayisi,Asker[] asker,int askersayisi) {
		for(int i=0;i<binasayisi;i++) {
			for(int j=0;j<askersayisi;j++) {				
				if(bina[i].vurus>0) {
					if(bina[i].vurus>asker[j].can) {
						bina[i].vurus-=asker[j].can;
						asker[j].can=0;
					}else {
						asker[j].can-=bina[i].vurus;
						bina[i].vurus=0;break;
					}
				}
				else break;	
			}
		}		
	}
	public int KuleKaleSilme(SavunmaBinasi[] bina,int binaSayisi) {
		
		int nmbr=binaSayisi;
		for(int i=0;i<binaSayisi;i++) {
			if(bina[i].can==0) {				
				bina[i]=null;
				nmbr-=1;					
			}
		}return nmbr;
	}
	public void gucDagilimi(Asker[] asker,int askerSayisi,int guc,int toplamGuc) {
		for(int i=0;i<askerSayisi;i++) {
			if(toplamGuc>guc) {
				asker[askerSayisi-i-1].vurus=guc;
				toplamGuc-=guc;
			}else {
				asker[askerSayisi-i-1].vurus=toplamGuc;	
				toplamGuc=0;
			}		
		}
	}public void okcuVurusDegistir() {
		for(int i=0;i<this.okcuSayisi;i++) {
			this.okcu[i].change();
		}		
	}
	
	public int play(Oyuncu player) {
		
		int saldiriGucu=0;
		boolean piyadeSaldirdiMi=false;
		boolean suvariSaldirdiMi=false;
		saldiriGucu+=saldirBina(player, okcu, okcuSayisi, true);			
		player.controlKule=player.KuleKaleSilme(player.kule, player.controlKule);
		
		player.controlKale=player.KuleKaleSilme(player.kale, player.controlKale);		
		sortingBina(player.kale, player.controlKale);		
		sortingBina(player.kule, player.controlKule);
		
		gucDagilimi(okcu, okcuSayisi, 8, saldiriGucu);		
		if(!(saldiriGucu>0)) {
			piyadeSaldirdiMi=true;
			saldiriGucu+=saldirBina(player, piyade, piyadeSayisi, false);			
			
			KuleKaleSavunma(player.kule, player.controlKule, piyade, piyadeSayisi);			
			KuleKaleSavunma(player.kale, player.controlKale, piyade, piyadeSayisi);				
			player.controlKule=player.KuleKaleSilme(player.kule, player.controlKule);
			player.controlKule=player.KuleKaleSilme(player.kale, player.controlKale);			
			sortingBina(player.kale, player.controlKale);
			sortingBina(player.kule, player.controlKule);
			piyadeSayisi=delete(piyade, piyadeSayisi);
			gucDagilimi(piyade, piyadeSayisi, 10, saldiriGucu);
			
		}
		if(!(saldiriGucu>0)) {			
			suvariSaldirdiMi=true;
			saldiriGucu+=saldirBina(player, suvari, suvariSayisi, false);			
			KuleKaleSavunma(player.kule, player.controlKule, suvari, suvariSayisi);
			KuleKaleSavunma(player.kale, player.controlKale, suvari, suvariSayisi);				
			player.controlKule=player.KuleKaleSilme(player.kule, player.controlKule);
			player.controlKale=player.KuleKaleSilme(player.kale, player.controlKale);			
			sortingBina(player.kale, player.controlKale);
			sortingBina(player.kule, player.controlKule);
			suvariSayisi=delete(suvari,suvariSayisi);
			gucDagilimi(suvari, suvariSayisi, 40, saldiriGucu);
		}
		if(!piyadeSaldirdiMi&&!suvariSaldirdiMi) {//okcu okcu
			if(piyadeSayisi>0||suvariSayisi>0) {
				int defans=player.saldirmaKuvveti(player.okcu, player.okcuSayisi);
				for(int i=0;i<player.okcuSayisi;i++) {
					if(saldiriGucu>player.okcu[i].can) {
						saldiriGucu-=player.okcu[i].can;
						player.okcu[i].can=0;						
					}
					else {
						player.okcu[i].can-=saldiriGucu;
						saldiriGucu=0;
					}
				}
				for(int i=0;i<okcuSayisi;i++) {
					if(defans>okcu[i].can) {
						defans-=okcu[i].can;
						okcu[i].can=0;						
					}
					else {
						okcu[i].can-=defans;
						defans=0;
					}
				}okcuSayisi=delete(okcu, okcuSayisi);
				player.okcuSayisi=player.delete(player.okcu, player.okcuSayisi);
				gucDagilimi(okcu, okcuSayisi, 8, saldiriGucu);
				player.gucDagilimi(player.okcu, player.okcuSayisi, 8, defans);
				if(saldiriGucu>0) {//okcu piyade
					for(int i=0;i<player.piyadeSayisi;i++) {
						if(saldiriGucu>player.piyade[i].can) {
							saldiriGucu-=player.piyade[i].can;
							player.piyade[i].can=0;						
						}
						else {
							player.piyade[i].can-=saldiriGucu;
							saldiriGucu=0;
						}
					}
					player.piyadeSayisi=player.delete(player.piyade, player.piyadeSayisi);
					gucDagilimi(okcu, okcuSayisi, 8, saldiriGucu);
				}				
								
				if(saldiriGucu>0) {//okcu suvari
					for(int i=0;i<player.suvariSayisi;i++) {
						if(saldiriGucu>player.suvari[i].can) {
							saldiriGucu-=player.suvari[i].can;
							player.suvari[i].can=0;						
						}
						else {
							player.suvari[i].can-=saldiriGucu;
							saldiriGucu=0;
						}
					}					
					player.suvariSayisi=player.delete(player.suvari, player.suvariSayisi);					
					gucDagilimi(okcu, okcuSayisi, 8, saldiriGucu);
				}				
			}else System.out.println("suvari piyade yok");
		}
		if(!suvariSaldirdiMi) {
			saldiriGucu=saldirmaKuvveti(piyade, piyadeSayisi);
			System.out.println(saldiriGucu);
			if(saldiriGucu>0) {
				player.okcuVurusDegistir();
				int defans=player.saldirmaKuvveti(player.okcu, player.okcuSayisi);
				for(int i=0;i<player.okcuSayisi;i++) {
					if(saldiriGucu>player.okcu[i].can) {
						saldiriGucu-=player.okcu[i].can;
						player.okcu[i].can=0;						
					}
					else {
						player.okcu[i].can-=saldiriGucu;
						saldiriGucu=0;
					}
				}
				for(int i=0;i<piyadeSayisi;i++) {					
					if(defans>piyade[i].can) {
						defans-=piyade[i].can;
						piyade[i].can=0;						
					}
					else {
						piyade[i].can-=defans;
						defans=0;
					}
				}piyadeSayisi=delete(piyade, piyadeSayisi);
				player.okcuSayisi=player.delete(player.okcu, player.okcuSayisi);
				gucDagilimi(piyade, piyadeSayisi, 10, saldiriGucu);
				player.gucDagilimi(player.okcu, player.okcuSayisi, 5, defans);
			}if(saldiriGucu>0) {
				int defans=player.saldirmaKuvveti(player.piyade, player.piyadeSayisi);
				for(int i=0;i<player.piyadeSayisi;i++) {
					if(saldiriGucu>player.piyade[i].can) {
						saldiriGucu-=player.piyade[i].can;
						player.piyade[i].can=0;						
					}
					else {
						player.piyade[i].can-=saldiriGucu;
						saldiriGucu=0;
					}
				}
				for(int i=0;i<piyadeSayisi;i++) {
					if(defans>piyade[i].can) {
						defans-=piyade[i].can;
						piyade[i].can=0;						
					}
					else {
						piyade[i].can-=defans;
						defans=0;
					}
				}piyadeSayisi=delete(piyade, piyadeSayisi);
				player.piyadeSayisi=player.delete(player.piyade, player.piyadeSayisi);
				gucDagilimi(piyade, piyadeSayisi, 10, saldiriGucu);
				player.gucDagilimi(player.piyade, player.piyadeSayisi, 10, defans);
			}
			if(saldiriGucu>0) {
				int defans=player.saldirmaKuvveti(player.suvari, player.suvariSayisi);
				for(int i=0;i<player.suvariSayisi;i++) {
					if(saldiriGucu>player.suvari[i].can) {
						saldiriGucu-=player.suvari[i].can;
						player.suvari[i].can=0;						
					}
					else {
						player.suvari[i].can-=saldiriGucu;
						saldiriGucu=0;
					}
				}
				for(int i=0;i<piyadeSayisi;i++) {
					if(defans>piyade[i].can) {
						defans-=piyade[i].can;
						piyade[i].can=0;						
					}
					else {
						piyade[i].can-=defans;
						defans=0;
					}
				}piyadeSayisi=delete(piyade, piyadeSayisi);
				player.suvariSayisi=player.delete(player.suvari, player.suvariSayisi);
				gucDagilimi(piyade, piyadeSayisi, 10, saldiriGucu);
				player.gucDagilimi(player.suvari, player.suvariSayisi, 40, defans);
			}
		}if(suvariSaldirdiMi) {
			saldiriGucu=saldirmaKuvveti(suvari, suvariSayisi);
			if(saldiriGucu>0) {
				player.okcuVurusDegistir();
				int defans=player.saldirmaKuvveti(player.okcu, player.okcuSayisi);
				for(int i=0;i<player.okcuSayisi;i++) {
					if(saldiriGucu>player.okcu[i].can) {
						saldiriGucu-=player.okcu[i].can;
						player.okcu[i].can=0;						
					}
					else {
						player.okcu[i].can-=saldiriGucu;
						saldiriGucu=0;
					}
				}
				for(int i=0;i<okcuSayisi;i++) {
					if(defans>suvari[i].can) {
						defans-=suvari[i].can;
						suvari[i].can=0;						
					}
					else {
						suvari[i].can-=defans;
						defans=0;
					}
				}suvariSayisi=delete(suvari, suvariSayisi);
				player.okcuSayisi=player.delete(player.okcu, player.okcuSayisi);
				gucDagilimi(suvari, suvariSayisi, 40, saldiriGucu);
				player.gucDagilimi(player.okcu, player.okcuSayisi, 5, defans);
			}if(saldiriGucu>0) {
				int defans=player.saldirmaKuvveti(player.piyade, player.piyadeSayisi);
				for(int i=0;i<player.piyadeSayisi;i++) {
					if(saldiriGucu>player.piyade[i].can) {
						saldiriGucu-=player.piyade[i].can;
						player.piyade[i].can=0;						
					}
					else {
						player.piyade[i].can-=saldiriGucu;
						saldiriGucu=0;
					}
				}
				for(int i=0;i<piyadeSayisi;i++) {
					if(defans>suvari[i].can) {
						defans-=suvari[i].can;
						suvari[i].can=0;						
					}
					else {
						suvari[i].can-=defans;
						defans=0;
					}
				}suvariSayisi=delete(suvari, suvariSayisi);
				player.piyadeSayisi=player.delete(player.piyade, player.piyadeSayisi);
				gucDagilimi(suvari, suvariSayisi, 40, saldiriGucu);
				player.gucDagilimi(player.piyade, player.piyadeSayisi, 10, defans);
			}
			if(saldiriGucu>0) {
				int defans=player.saldirmaKuvveti(player.suvari, player.suvariSayisi);
				for(int i=0;i<player.suvariSayisi;i++) {
					if(saldiriGucu>player.suvari[i].can) {
						saldiriGucu-=player.suvari[i].can;
						player.suvari[i].can=0;						
					}
					else {
						player.suvari[i].can-=saldiriGucu;
						saldiriGucu=0;
					}
				}
				for(int i=0;i<suvariSayisi;i++) {
					if(defans>suvari[i].can) {
						defans-=suvari[i].can;
						suvari[i].can=0;						
					}
					else {
						suvari[i].can-=defans;
						defans=0;
					}
				}suvariSayisi=delete(suvari, suvariSayisi);
				player.suvariSayisi=player.delete(player.suvari, player.suvariSayisi);
				gucDagilimi(suvari, suvariSayisi, 10, saldiriGucu);
				player.gucDagilimi(player.suvari, player.suvariSayisi, 40, defans);
			}
		}saldiriGucu=saldirmaKuvveti(okcu, okcuSayisi)+saldirmaKuvveti(piyade, piyadeSayisi)+saldirmaKuvveti(suvari, suvariSayisi);
		if(saldiriGucu>0) {
			player.can-=saldiriGucu;
			player.gucYukleme();
			gucYukleme();
			return player.can;
		}player.gucYukleme();
		gucYukleme();
		return 101;		
	}	
}
