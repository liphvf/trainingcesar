package training.bms.business;


public class TagSearchOptions {

//	public TagSearchOptions() {
////		// deixa esse como default
////
////		order = Order.TITLE;
//	}
//
//	public enum Order {
//		TITLE("name");
//
//		private String value;
//
//		private Order(String value) {
//			this.value = value;
//		}
//
//		public String getValue() {
//			return value;
//		}
//
//		public void setValue(String value) {
//			this.value = value;
//		}
//
//	}

	private Integer id;
	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
