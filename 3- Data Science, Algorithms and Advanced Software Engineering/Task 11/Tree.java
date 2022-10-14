/** 
 * Object for the HangingObject.java 
 * 
 * 
 * 
 * */
public class Tree {
		
		private String name = "";
		private String type = "";
		private String climate = "";
		private int nameHash = 0;
		private int typeHash = 0;
		private int climateHash = 0;
		
		
		public Tree(String name, String type, String climate) {
			this.name = name;
			this.type = type;
			this.climate = climate;
			
		}
		
		public void setName(String name) {
			this.name = name;
		}
		public void setType(String type) {
			this.type = type;
		}
		public void setClimate(String climate) {
			this.climate = climate;
		}
		public String getName() {
			return this.name;
		}
		public String getType() {

			return this.type;
		}
		public String getClimate() {

			return this.climate;
		}
		public void setNameHash(int nameHash) {
			this.nameHash = nameHash;
		}
		public void setTypeHash(int typeHash) {
			this.typeHash = typeHash;
			}
		public void setClimateHash(int climateHash) {
			this.climateHash = climateHash;
			}

		public int getNameHash() {
			return this.nameHash;
		}
		public int getTypeHash() {
			return this.typeHash;			
		}
		public int getClimateHash() {
			return this.climateHash;
			}
		
		public int returnHash(String attribute, String data) {
			int attrHash = 0; 
	
				for(int y = 0; y < data.length(); y++) {
					attrHash += data.charAt(y) * 31^(data.length() - (y + 1));
				}
				if(attribute.equalsIgnoreCase("name")) {
					setNameHash(attrHash);
				}
				else if(attribute.equalsIgnoreCase("type")) {
					setTypeHash(attrHash);			
				}
				else if(attribute.equalsIgnoreCase("climate")) {
					setClimateHash(attrHash);					
				}
			return attrHash;
		}
		/* @Override */
		public void toString(int[] hashes) {
			System.out.print("Tree name: " + this.name);			
			System.out.println(", Hash: " + this.nameHash);
			System.out.print("Tree type: " + this.type);
			System.out.println(", Hash: " + this.typeHash);
			System.out.print("Climate  : " + this.climate);
			System.out.println(", Hash: " + this.climateHash);
			
			
		}
	}

