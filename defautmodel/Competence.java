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
	* - time      : 2015/08/04 AD at 17:45:42 PKT
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
import defaultroot.defautmodel.domain.defautmodel.Script;
import defaultroot.defautmodel.domain.defautmodel.User;

/**
 *
 * <p>Title: Competence</p>
 *
 * <p>Description: Domain Object describing a Competence entity</p>
 *
 */
@Entity (name="Competence")
@Table (name="\"competence\"")
@NamedQueries ({
	 @NamedQuery(name="Competence.findAll", query="SELECT competence FROM Competence competence")
	,@NamedQuery(name="Competence.findByCompetenceName", query="SELECT competence FROM Competence competence WHERE competence.competenceName = :competenceName")
	,@NamedQuery(name="Competence.findByCompetenceNameContaining", query="SELECT competence FROM Competence competence WHERE competence.competenceName like :competenceName")

})

public class Competence implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String FIND_ALL = "Competence.findAll";
    public static final String FIND_BY_COMPETENCENAME = "Competence.findByCompetenceName";
    public static final String FIND_BY_COMPETENCENAME_CONTAINING ="Competence.findByCompetenceNameContaining";
	
    @Id @Column(name="competence_id" ) 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer competenceId;

//MP-MANAGED-ADDED-AREA-BEGINNING @competence_name-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @competence_name-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-competence_name@
    @Column(name="competence_name"  , length=45 , nullable=false , unique=false)
    private String competenceName; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @m2m-scriptViaScriptCompetenceByScriptId-competence@
    @ManyToMany
    @JoinTable(name="SCRIPT_COMPETENCE", 
        joinColumns=@JoinColumn(name="competence_id"), 
        inverseJoinColumns=@JoinColumn(name="script_id") 
    )
    private Set <Script> scriptViaScriptCompetenceByScriptId = new HashSet <Script> ();

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @m2m-userViaUserCompetenceByUserId-competence@
    @ManyToMany
    @JoinTable(name="USER_COMPETENCE", 
        joinColumns=@JoinColumn(name="competence_id"), 
        inverseJoinColumns=@JoinColumn(name="user_id") 
    )
    private Set <User> userViaUserCompetenceByUserId = new HashSet <User> ();

//MP-MANAGED-UPDATABLE-ENDING
    /**
    * Default constructor
    */
    public Competence() {
    }

	/**
	* All field constructor 
	*/
    public Competence(
       Integer competenceId,
       String competenceName) {
	 this(
       competenceId,
       competenceName
	 ,true);
	}
    
	public Competence(
       Integer competenceId,
       String competenceName	
    , boolean setRelationship) {
       //primary keys
       setCompetenceId (competenceId);
       //attributes
       setCompetenceName (competenceName);
       //parents
    }

	public Competence flat() {
	   return new Competence(
          getCompetenceId(),
          getCompetenceName()
       , false
	   );
	}

    public Integer getCompetenceId() {
        return competenceId;
    }
	
    public void setCompetenceId (Integer competenceId) {
        this.competenceId =  competenceId;
    }
    
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-competence_name@
    public String getCompetenceName() {
        return competenceName;
    }
	
    public void setCompetenceName (String competenceName) {
        this.competenceName =  competenceName;
    }
	
//MP-MANAGED-UPDATABLE-ENDING



//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @scriptCompetenceViaCompetenceByCompetenceId-getter-competence@
//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @userCompetenceViaCompetenceByCompetenceId-getter-competence@
//MP-MANAGED-UPDATABLE-ENDING

    public Set<Script> getScriptViaScriptCompetenceByScriptId() {
        if (scriptViaScriptCompetenceByScriptId == null){
            scriptViaScriptCompetenceByScriptId = new HashSet<Script>();
        }
        return scriptViaScriptCompetenceByScriptId;
    }

    public void setScriptViaScriptCompetenceByScriptId (Set<Script> scriptViaScriptCompetenceByScriptId) {
        this.scriptViaScriptCompetenceByScriptId = scriptViaScriptCompetenceByScriptId;
    }
    	
    public void addScriptViaScriptCompetenceByScriptId (Script element) {
        getScriptViaScriptCompetenceByScriptId().add(element);
    }
	
    public Set<User> getUserViaUserCompetenceByUserId() {
        if (userViaUserCompetenceByUserId == null){
            userViaUserCompetenceByUserId = new HashSet<User>();
        }
        return userViaUserCompetenceByUserId;
    }

    public void setUserViaUserCompetenceByUserId (Set<User> userViaUserCompetenceByUserId) {
        this.userViaUserCompetenceByUserId = userViaUserCompetenceByUserId;
    }
    	
    public void addUserViaUserCompetenceByUserId (User element) {
        getUserViaUserCompetenceByUserId().add(element);
    }
	


//MP-MANAGED-ADDED-AREA-BEGINNING @implementation@
//MP-MANAGED-ADDED-AREA-ENDING @implementation@

}
