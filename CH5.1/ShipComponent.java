public class ShipComponent{
	private Ship parentShip;
	
	public ShipComponent(Ship parentShip){
		this.parentShip = parentShip;
	}
	
	public Ship getParentShip(){
		return this.parentShip;
	}
}
