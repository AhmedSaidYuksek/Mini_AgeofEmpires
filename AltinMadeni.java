public class AltinMadeni extends UretimBinasi{
	public AltinMadeni() {
		eklenecekDeger=2;
	}
	public boolean 	isProducible(int odun,int tas,Oyuncu player){
		if(odun>=5&&tas>=20) {
			player.odun-=5;
			player.tas-=20;
			return true;
		}
		return false;
	}		
}
