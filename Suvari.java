public class Suvari extends Asker {		
	public Suvari() {
		can=20;
		vurus=40;
	}
	public boolean 	isProducible(int altin,int odun){
		if(altin>=2&&odun>=2) {
			altin-=2;
			odun-=2;
			return true;
		}
		return false;
	}	
}
