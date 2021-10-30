public class Bilgisayar extends Oyuncu {
	public boolean doItComputer(int nmbr,Oyuncu player) {
		int[] look= {1,2,3,4,5,8,7,6,0};
		if(nmbr%4==0&&(okcuSayisi+suvariSayisi+piyadeSayisi)>0) {			
			doIt(9, player);
			if(player.can<0) {
				System.out.println("Bilgisayar kazandi!");return true;
			}
		}
		else {
			boolean olduMu=false;			
			for(int i=0;i<9;i++) {				
				olduMu=doIt(look[i], player);
			if(olduMu)
				break;
			}		
		}return false;	
	}
	public boolean doIt(int whichOne,Oyuncu player ) {			
		switch (whichOne) {
		case 0:  System.out.println("pas"); return true;
		case 1: {
			if(controlAltin&&altinMadeni[0].isProducible(odun, tas,this)) {				
				altinMadeni[1]=new AltinMadeni();
				controlAltin=false;
				return true;
			}return false;		
		}
		case 2: {
			if(controlTas&&tasOcagi[0].isProducible(odun, tas,this)) {				
				tasOcagi[1]=new TasOcagi();
				
				controlTas=false;
				return true;
			}return false;		
		}
		case 3: {
			if(controlOdun&&odunUretimEvi[0].isProducible(odun,this)) {				
				odunUretimEvi[1]=new OdunUretimEvi();
				controlOdun=false;
				return true;
			}return false;		
		}
		case 4: {
			if(controlKule!=2&&altin>=1&&odun>=5&&tas>=20) {				
				kule[controlKule]=new Kule();
				controlKule++;
				return true;
			}return false;	
		}
		case 5: {
			if(controlKale!=2&&altin>=5&&odun>=15&&tas>=40) {			
				kale[controlKale]=new Kale();
				controlKale++;
				return true;
			}return false;	
		}
		case 8: {
			if(altin>=1&&odun>=2) {				
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
		default:
		if((okcuSayisi+suvariSayisi+piyadeSayisi)>0){
			if(play(player)==101)return true;			
		}return false;
			
		}		
	}
}
