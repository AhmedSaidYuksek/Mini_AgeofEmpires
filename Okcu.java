public class Okcu extends Asker{	
	int vurusUzak=8;
	int vurusYakin=5;
	public Okcu() {
		can=5;
		vurus=vurusUzak;
	}
	public void change() {
		vurus=vurusYakin;
	}
	public boolean 	isProducible(int altin,int odun){
		if(altin>=1&&odun>=5) {
			altin-=1;
			odun-=5;
			return true;
		}
		return false;
	}	
}
