package yachendra.com.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningControl {
	
	@GetMapping("v1/person")
	public PersonV1 personV1() {
		return new PersonV1("Suma");
	}

	@GetMapping("v2/person")
	public PersonV2 personV2() {
		return new PersonV2(new Name("Suma","Sireesha"));
	}
	
	// For choosing Versions Using Params
	
		@GetMapping(value = "person/param", params= "version=1")
		public PersonV1 paramV1() {
			return new PersonV1("Aadhya");
		}

		@GetMapping(value = "person/param", params= "version=2")
		public PersonV2 paramV2() {
			return new PersonV2(new Name("Aadhya","Shree"));
		}
			// For choosing Versions Using Headers
			
			@GetMapping(value = "person/header", headers= "X-API-VERSION=1")
			public PersonV1 headerV1() {
				return new PersonV1("Ashok");
			}

			@GetMapping(value = "person/header", headers= "X-API-VERSION=2")
			public PersonV2 headerV2() {
				return new PersonV2(new Name("Dega","Ashok Kumar"));
	}
			@GetMapping(value = "person/produces", produces= "application/vnd.company.app-v1+json")
			public PersonV1 producesV1() {
				return new PersonV1("Modiboyina");
			}

			@GetMapping(value = "person/produces", produces= "application/vnd.company.app-v2+json")
			public PersonV2 producesV2() {
				return new PersonV2(new Name("Modiboyina","Yachendra Kumar"));
			}
}
