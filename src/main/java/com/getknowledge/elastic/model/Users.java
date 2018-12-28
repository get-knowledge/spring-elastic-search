package com.getknowledge.elastic.model;

import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName="users" ,type="users" ,shards=1)
public class Users {

	
    	private Long id;
	 	private String name;
	    private String teamName;
	    private Long salary;
	    
	    
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getTeamName() {
			return teamName;
		}
		public void setTeamName(String teamName) {
			this.teamName = teamName;
		}
		public Long getSalary() {
			return salary;
		}
		public void setSalary(Long salary) {
			this.salary = salary;
		}
		public Users(Long id, String name, String teamName, Long salary) {
			this.id = id;
			this.name = name;
			this.teamName = teamName;
			this.salary = salary;
		}
		public Users() {
			
		}

}
