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
import defaultroot.defautmodel.domain.defautmodel.Privilege;
import defaultroot.defautmodel.domain.defautmodel.User;

/**
 *
 * <p>Title: Role</p>
 *
 * <p>Description: Domain Object describing a Role entity</p>
 *
 */
@Entity (name="Role")
@Table (name="\"role\"")
@NamedQueries ({
	 @NamedQuery(name="Role.findAll", query="SELECT role FROM Role role")
	,@NamedQuery(name="Role.findByRoleName", query="SELECT role FROM Role role WHERE role.roleName = :roleName")
	,@NamedQuery(name="Role.findByRoleNameContaining", query="SELECT role FROM Role role WHERE role.roleName like :roleName")

})

public class Role implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String FIND_ALL = "Role.findAll";
    public static final String FIND_BY_ROLENAME = "Role.findByRoleName";
    public static final String FIND_BY_ROLENAME_CONTAINING ="Role.findByRoleNameContaining";
	
    @Id @Column(name="role_id" ) 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer roleId;

//MP-MANAGED-ADDED-AREA-BEGINNING @role_name-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @role_name-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-role_name@
    @Column(name="role_name"  , length=45 , nullable=true , unique=false)
    private String roleName; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @m2m-privilegeViaRolePrivilegeByPrivilegeId-role@
    @ManyToMany
    @JoinTable(name="ROLE_PRIVILEGE", 
        joinColumns=@JoinColumn(name="role_id"), 
        inverseJoinColumns=@JoinColumn(name="privilege_id") 
    )
    private Set <Privilege> privilegeViaRolePrivilegeByPrivilegeId = new HashSet <Privilege> ();

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @m2m-userViaUserRoleByUserId-role@
    @ManyToMany
    @JoinTable(name="USER_ROLE", 
        joinColumns=@JoinColumn(name="role_id"), 
        inverseJoinColumns=@JoinColumn(name="user_id") 
    )
    private Set <User> userViaUserRoleByUserId = new HashSet <User> ();

//MP-MANAGED-UPDATABLE-ENDING
    /**
    * Default constructor
    */
    public Role() {
    }

	/**
	* All field constructor 
	*/
    public Role(
       Integer roleId,
       String roleName) {
	 this(
       roleId,
       roleName
	 ,true);
	}
    
	public Role(
       Integer roleId,
       String roleName	
    , boolean setRelationship) {
       //primary keys
       setRoleId (roleId);
       //attributes
       setRoleName (roleName);
       //parents
    }

	public Role flat() {
	   return new Role(
          getRoleId(),
          getRoleName()
       , false
	   );
	}

    public Integer getRoleId() {
        return roleId;
    }
	
    public void setRoleId (Integer roleId) {
        this.roleId =  roleId;
    }
    
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-role_name@
    public String getRoleName() {
        return roleName;
    }
	
    public void setRoleName (String roleName) {
        this.roleName =  roleName;
    }
	
//MP-MANAGED-UPDATABLE-ENDING



//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @rolePrivilegeViaRoleByRoleId-getter-role@
//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @userRoleViaRoleByRoleId-getter-role@
//MP-MANAGED-UPDATABLE-ENDING

    public Set<Privilege> getPrivilegeViaRolePrivilegeByPrivilegeId() {
        if (privilegeViaRolePrivilegeByPrivilegeId == null){
            privilegeViaRolePrivilegeByPrivilegeId = new HashSet<Privilege>();
        }
        return privilegeViaRolePrivilegeByPrivilegeId;
    }

    public void setPrivilegeViaRolePrivilegeByPrivilegeId (Set<Privilege> privilegeViaRolePrivilegeByPrivilegeId) {
        this.privilegeViaRolePrivilegeByPrivilegeId = privilegeViaRolePrivilegeByPrivilegeId;
    }
    	
    public void addPrivilegeViaRolePrivilegeByPrivilegeId (Privilege element) {
        getPrivilegeViaRolePrivilegeByPrivilegeId().add(element);
    }
	
    public Set<User> getUserViaUserRoleByUserId() {
        if (userViaUserRoleByUserId == null){
            userViaUserRoleByUserId = new HashSet<User>();
        }
        return userViaUserRoleByUserId;
    }

    public void setUserViaUserRoleByUserId (Set<User> userViaUserRoleByUserId) {
        this.userViaUserRoleByUserId = userViaUserRoleByUserId;
    }
    	
    public void addUserViaUserRoleByUserId (User element) {
        getUserViaUserRoleByUserId().add(element);
    }
	


//MP-MANAGED-ADDED-AREA-BEGINNING @implementation@
//MP-MANAGED-ADDED-AREA-ENDING @implementation@

}
