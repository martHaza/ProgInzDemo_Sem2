package lv.venta.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "MyAuthorityTable")
@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString
public class MyAuthority {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "AId")
	@Setter(value = AccessLevel.NONE)
	private int aId;
	
	@NotNull
	@Pattern(regexp = "[A-Z_]{3,10}")
	@Column(name = "Title")
	private String title;


	public MyAuthority(String title) {
		this.title = title;
	}

}
