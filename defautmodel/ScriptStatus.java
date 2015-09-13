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
import defaultroot.defautmodel.domain.defautmodel.Script;

/**
 *
 * <p>Title: ScriptStatus</p>
 *
 * <p>Description: Domain Object describing a ScriptStatus entity</p>
 *
 */
@Entity (name="ScriptStatus")
@Table (name="\"script_status\"")
@NamedQueries ({
	 @NamedQuery(name="ScriptStatus.findAll", query="SELECT scriptstatus FROM ScriptStatus scriptstatus")
	,@NamedQuery(name="ScriptStatus.findByScriptStatus", query="SELECT scriptstatus FROM ScriptStatus scriptstatus WHERE scriptstatus.scriptStatus = :scriptStatus")
	,@NamedQuery(name="ScriptStatus.findByScriptStatusContaining", query="SELECT scriptstatus FROM ScriptStatus scriptstatus WHERE scriptstatus.scriptStatus like :scriptStatus")

})

public class ScriptStatus implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String FIND_ALL = "ScriptStatus.findAll";
    public static final String FIND_BY_SCRIPTSTATUS = "ScriptStatus.findByScriptStatus";
    public static final String FIND_BY_SCRIPTSTATUS_CONTAINING ="ScriptStatus.findByScriptStatusContaining";
	
    @Id @Column(name="script_status_id" ) 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer scriptStatusId;

//MP-MANAGED-ADDED-AREA-BEGINNING @script_status-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @script_status-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-script_status@
    @Column(name="script_status"  , length=45 , nullable=false , unique=false)
    private String scriptStatus; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @scriptScriptStatusViaScriptStatusId-field-script_status@
    @OneToMany (targetEntity=defaultroot.defautmodel.domain.defautmodel.Script.class, fetch=FetchType.LAZY, mappedBy="scriptStatusId", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <Script> scriptScriptStatusViaScriptStatusId = new HashSet<Script>(); 

//MP-MANAGED-UPDATABLE-ENDING
    /**
    * Default constructor
    */
    public ScriptStatus() {
    }

	/**
	* All field constructor 
	*/
    public ScriptStatus(
       Integer scriptStatusId,
       String scriptStatus) {
	 this(
       scriptStatusId,
       scriptStatus
	 ,true);
	}
    
	public ScriptStatus(
       Integer scriptStatusId,
       String scriptStatus	
    , boolean setRelationship) {
       //primary keys
       setScriptStatusId (scriptStatusId);
       //attributes
       setScriptStatus (scriptStatus);
       //parents
    }

	public ScriptStatus flat() {
	   return new ScriptStatus(
          getScriptStatusId(),
          getScriptStatus()
       , false
	   );
	}

    public Integer getScriptStatusId() {
        return scriptStatusId;
    }
	
    public void setScriptStatusId (Integer scriptStatusId) {
        this.scriptStatusId =  scriptStatusId;
    }
    
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-script_status@
    public String getScriptStatus() {
        return scriptStatus;
    }
	
    public void setScriptStatus (String scriptStatus) {
        this.scriptStatus =  scriptStatus;
    }
	
//MP-MANAGED-UPDATABLE-ENDING



//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @scriptScriptStatusViaScriptStatusId-getter-script_status@
    public Set<Script> getScriptScriptStatusViaScriptStatusId() {
        if (scriptScriptStatusViaScriptStatusId == null){
            scriptScriptStatusViaScriptStatusId = new HashSet<Script>();
        }
        return scriptScriptStatusViaScriptStatusId;
    }

    public void setScriptScriptStatusViaScriptStatusId (Set<Script> scriptScriptStatusViaScriptStatusId) {
        this.scriptScriptStatusViaScriptStatusId = scriptScriptStatusViaScriptStatusId;
    }	
    
    public void addScriptScriptStatusViaScriptStatusId (Script element) {
    	    getScriptScriptStatusViaScriptStatusId().add(element);
    }
    
//MP-MANAGED-UPDATABLE-ENDING



//MP-MANAGED-ADDED-AREA-BEGINNING @implementation@
//MP-MANAGED-ADDED-AREA-ENDING @implementation@

}
