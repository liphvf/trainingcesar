package collection;

public class ObjectHolder<Saulo> implements IObjectHolder<Saulo> { 
	private Saulo object;
	
	public void setObject(Saulo object) {
		this.object = object;
	}
	
	public Saulo getObject() {
		return object;
	}
	
	public static void main(String[] args) {
		IObjectHolder<String> holder = new ObjectHolder<String>();
		holder.setObject("Saulo");
		String nome = holder.getObject();
		System.out.println(nome);
	}
}











