/**
	* Copyright (c) minuteproject, minuteproject@gmail.com
	* All rights reserved.
	* 
	* Licensed under the Apache License, Version 2.0 (the "License")
	* you may not use this file except in compliance with the License.
	* You may obtain a copy of the License at
	* 
	* http://www.apache.org/licenses/LICENSE-2.0
	* 
	* Unless required by applicable law or agreed to in writing, software
	* distributed under the License is distributed on an "AS IS" BASIS,
	* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	* See the License for the specific language governing permissions and
	* limitations under the License.
	* 
	* More information on minuteproject:
	* twitter @minuteproject
	* wiki http://minuteproject.wikispaces.com 
	* blog http://minuteproject.blogspot.net
	* 
*/
/**
	* template reference : 
	* - Minuteproject version : 0.9
	* - name      : DomainEntityJPA2Annotation
	* - file name : DomainEntityJPA2Annotation.vm
*/
package defaultroot.defautmodel.domain.defautmodel;

//MP-MANAGED-ADDED-AREA-BEGINNING @import@
//MP-MANAGED-ADDED-AREA-ENDING @import@
import java.sql.*;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

import java.io.Serializable;
import javax.persistence.*;
import defaultroot.defautmodel.domain.defautmodel.Role;

/**
 *
 * <p>Title: Privilege</p>
 *
 * <p>Description: Domain Object describing a Privilege entity</p>
 *
 */
@Entity (name="Privilege")
@Table (name="\"privilege\"")
@NamedQueries ({
	 @NamedQuery(name="Privilege.findAll", query="SELECT privilege FROM Privilege privilege")
	,@NamedQuery(name="Privilege.findByPrivilegeName", query="SELECT privilege FROM Privilege privilege WHERE privilege.privilegeName = :privilegeName")
	,@NamedQuery(name="Privilege.findByPrivilegeNameContaining", query="SELECT privilege FROM Privilege privilege WHERE privilege.privilegeName like :privilegeName")

})

public class Privilege implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String FIND_ALL = "Privilege.findAll";
    public static final String FIND_BY_PRIVILEGENAME = "Privilege.findByPrivilegeName";
    public static final String FIND_BY_PRIVILEGENAME_CONTAINING ="Privilege.findByPrivilegeNameContaining";
	
    @Id @Column(name="privilege_id" ) 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer privilegeId;

//MP-MANAGED-ADDED-AREA-BEGINNING @privilege_name-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @privilege_name-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-privilege_name@
    @Column(name="privilege_name"  , length=100 , nullable=false , unique=false)
    private String privilegeName; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @m2m-roleViaRolePrivilegeByRoleId-privilege@
    @ManyToMany
    @JoinTable(name="ROLE_PRIVILEGE", 
        joinColumns=@JoinColumn(name="privilege_id"), 
        inverseJoinColumns=@JoinColumn(name="role_id") 
    )
    private Set <Role> roleViaRolePrivilegeByRoleId = new HashSet <Role> ();

//MP-MANAGED-UPDATABLE-ENDING
    /**
    * Default constructor
    */
    public Privilege() {
    }

	/**
	* All field constructor 
	*/
    public Privilege(
       Integer privilegeId,
       String privilegeName) {
	 this(
       privilegeId,
       privilegeName
	 ,true);
	}
    
	public Privilege(
       Integer privilegeId,
       String privilegeName	
    , boolean setRelationship) {
       //primary keys
       setPrivilegeId (privilegeId);
       //attributes
       setPrivilegeName (privilegeName);
       //parents
    }

	public Privilege flat() {
	   return new Privilege(
          getPrivilegeId(),
          getPrivilegeName()
       , false
	   );
	}

    public Integer getPrivilegeId() {
        return privilegeId;
    }
	
    public void setPrivilegeId (Integer privilegeId) {
        this.privilegeId =  privilegeId;
    }
    
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-privilege_name@
    public String getPrivilegeName() {
        return privilegeName;
    }
	
    public void setPrivilegeName (String privilegeName) {
        this.privilegeName =  privilegeName;
    }
	
//MP-MANAGED-UPDATABLE-ENDING



//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @rolePrivilegeViaPrivilegeByPrivilegeId-getter-privilege@
//MP-MANAGED-UPDATABLE-ENDING

    public Set<Role> getRoleViaRolePrivilegeByRoleId() {
        if (roleViaRolePrivilegeByRoleId == null){
            roleViaRolePrivilegeByRoleId = new HashSet<Role>();
        }
        return roleViaRolePrivilegeByRoleId;
    }

    public void setRoleViaRolePrivilegeByRoleId (Set<Role> roleViaRolePrivilegeByRoleId) {
        this.roleViaRolePrivilegeByRoleId = roleViaRolePrivilegeByRoleId;
    }
    	
    public void addRoleViaRolePrivilegeByRoleId (Role element) {
        getRoleViaRolePrivilegeByRoleId().add(element);
    }
	


//MP-MANAGED-ADDED-AREA-BEGINNING @implementation@
//MP-MANAGED-ADDED-AREA-ENDING @implementation@

}
