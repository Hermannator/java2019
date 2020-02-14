package encapsulation;
import java.util.Date;

public class Person {
	private String name, email;
	private Date birthday;
	private char gender;
	public void setName(String name) {
		if(name.matches("[A-Z][a-z]+ [A-Z][a-z]+")) {
			this.name = name;
		}else {
			throw new IllegalArgumentException("Invalid name.");
		}
	}
	public void setEmail(String email) {
		if (email == null || email.matches(name.split(" ")[0].toLowerCase() + "\\." + name.split(" ")[1].toLowerCase() + "@[a-z0-9]+\\.(ad|ae|af|ag|ai|al|am|ao|aq|ar|as|at|au|aw|ax|az|ba|bb|bd|be|bf|bg|bh|bi|bj|bl|bm|bn|bo|bq|br|bs|bt|bv|bw|by|bz|ca|cc|cd|cf|cg|ch|ci|ck|cl|cm|cn|co|cr|cu|cv|cw|cx|cy|cz|de|dj|dk|dm|do|dz|ec|ee|eg|eh|er|es|et|fi|fj|fk|fm|fo|fr|ga|gb|gd|ge|gf|gg|gh|gi|gl|gm|gn|gp|gq|gr|gs|gt|gu|gw|gy|hk|hm|hn|hr|ht|hu|id|ie|il|im|in|io|iq|ir|is|it|je|jm|jo|jp|ke|kg|kh|ki|km|kn|kp|kr|kw|ky|kz|la|lb|lc|li|lk|lr|ls|lt|lu|lv|ly|ma|mc|md|me|mf|mg|mh|mk|ml|mm|mn|mo|mp|mq|mr|ms|mt|mu|mv|mw|mx|my|mz|na|nc|ne|nf|ng|ni|nl|no|np|nr|nu|nz|om|pa|pe|pf|pg|ph|pk|pl|pm|pn|pr|ps|pt|pw|py|qa|re|ro|rs|ru|rw|sa|sb|sc|sd|se|sg|sh|si|sj|sk|sl|sm|sn|so|sr|ss|st|sv|sx|sy|sz|tc|td|tf|tg|th|tj|tk|tl|tm|tn|to|tr|tt|tv|tw|tz|ua|ug|um|us|uy|uz|va|vc|ve|vg|vi|vn|vu|wf|ws|ye|yt|za|zm|zw)")) {
			this.email = email;
		}else {
			throw new IllegalArgumentException("Invalid e-mail.");
		}
	}
	public void setBirthday(Date birthday) {
		Date today = new Date();
		if(birthday.before(today)) {
			this.birthday = birthday;
		}else {
			throw new IllegalArgumentException("Invalid birthday.");
		}
	}
	public void setGender(char gender) {
		if(gender == 'M' || gender == 'F' || gender == '\0') {
			this.gender = gender;
		}else {
			throw new IllegalArgumentException("Invalid gender.");
		}
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public Date getBirthday() {
		return birthday;
	}
	public char getGender() {
		return gender;
	}
	public static void main(String[] args) {
		Person p1 = new Person();
		p1.setName("John Doe");
		System.out.println(p1.getName());
		p1.setEmail("john.doe@o.ad");
		System.out.println(p1.getEmail());
		p1.setGender('M');
		System.out.println(p1.getGender());
	}
}
