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
import defaultroot.defautmodel.domain.defautmodel.User;

/**
 *
 * <p>Title: App</p>
 *
 * <p>Description: Domain Object describing a App entity</p>
 *
 */
@Entity (name="App")
@Table (name="\"app\"")
@NamedQueries ({
	 @NamedQuery(name="App.findAll", query="SELECT app FROM App app")
	,@NamedQuery(name="App.findByHost", query="SELECT app FROM App app WHERE app.host = :host")
	,@NamedQuery(name="App.findByHostContaining", query="SELECT app FROM App app WHERE app.host like :host")

	,@NamedQuery(name="App.findByIsActive", query="SELECT app FROM App app WHERE app.isActive = :isActive")

})

public class App implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String FIND_ALL = "App.findAll";
    public static final String FIND_BY_HOST = "App.findByHost";
    public static final String FIND_BY_HOST_CONTAINING ="App.findByHostContaining";
    public static final String FIND_BY_ISACTIVE = "App.findByIsActive";
	
    @Id @Column(name="app_id" ,length=36) 
    private String appId;

//MP-MANAGED-ADDED-AREA-BEGINNING @host-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @host-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-host@
    @Column(name="host"  , length=255 , nullable=false , unique=false)
    private String host; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @is_active-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @is_active-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-is_active@
    @Column(name="is_active"   , nullable=false , unique=false)
    private Boolean isActive; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @userAppViaAppSourceKey-field-app@
    @OneToMany (targetEntity=defaultroot.defautmodel.domain.defautmodel.User.class, fetch=FetchType.LAZY, mappedBy="appSourceKey", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <User> userAppViaAppSourceKey = new HashSet<User>(); 

//MP-MANAGED-UPDATABLE-ENDING
    /**
    * Default constructor
    */
    public App() {
    }

	/**
	* All field constructor 
	*/
    public App(
       String appId,
       String host,
       Boolean isActive) {
	 this(
       appId,
       host,
       isActive
	 ,true);
	}
    
	public App(
       String appId,
       String host,
       Boolean isActive	
    , boolean setRelationship) {
       //primary keys
       setAppId (appId);
       //attributes
       setHost (host);
       setIsActive (isActive);
       //parents
    }

	public App flat() {
	   return new App(
          getAppId(),
          getHost(),
          getIsActive()
       , false
	   );
	}

    public String getAppId() {
        return appId;
    }
	
    public void setAppId (String appId) {
        this.appId =  appId;
    }
    
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-host@
    public String getHost() {
        return host;
    }
	
    public void setHost (String host) {
        this.host =  host;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-is_active@
    public Boolean getIsActive() {
        return isActive;
    }
	
    public void setIsActive (Boolean isActive) {
        this.isActive =  isActive;
    }
	
//MP-MANAGED-UPDATABLE-ENDING



//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @userAppViaAppSourceKey-getter-app@
    public Set<User> getUserAppViaAppSourceKey() {
        if (userAppViaAppSourceKey == null){
            userAppViaAppSourceKey = new HashSet<User>();
        }
        return userAppViaAppSourceKey;
    }

    public void setUserAppViaAppSourceKey (Set<User> userAppViaAppSourceKey) {
        this.userAppViaAppSourceKey = userAppViaAppSourceKey;
    }	
    
    public void addUserAppViaAppSourceKey (User element) {
    	    getUserAppViaAppSourceKey().add(element);
    }
    
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @prepersist-app@
    @javax.persistence.PrePersist
    public void prePersist_ () {
    }
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @preupdate-app@
    @javax.persistence.PreUpdate
    public void preUpdate_ () {
    }
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @implementation@
//MP-MANAGED-ADDED-AREA-ENDING @implementation@

}
