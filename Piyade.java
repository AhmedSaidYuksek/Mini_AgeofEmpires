public class Piyade extends Asker{
	public Piyade() {
		can=10;
		vurus=10;
	}
	public boolean 	isProducible(int altin,int odun){
		if(altin>=1&&odun>=2) {
			altin-=1;
			odun-=2;
			return true;
		}
		return false;
	}
}
