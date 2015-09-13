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
import defaultroot.defautmodel.domain.defautmodel.Price;
import defaultroot.defautmodel.domain.defautmodel.Script;

/**
 *
 * <p>Title: ScriptType</p>
 *
 * <p>Description: Domain Object describing a ScriptType entity</p>
 *
 */
@Entity (name="ScriptType")
@Table (name="\"script_type\"")
@NamedQueries ({
	 @NamedQuery(name="ScriptType.findAll", query="SELECT scripttype FROM ScriptType scripttype")
	,@NamedQuery(name="ScriptType.findByScriptType", query="SELECT scripttype FROM ScriptType scripttype WHERE scripttype.scriptType = :scriptType")
	,@NamedQuery(name="ScriptType.findByScriptTypeContaining", query="SELECT scripttype FROM ScriptType scripttype WHERE scripttype.scriptType like :scriptType")

})

public class ScriptType implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String FIND_ALL = "ScriptType.findAll";
    public static final String FIND_BY_SCRIPTTYPE = "ScriptType.findByScriptType";
    public static final String FIND_BY_SCRIPTTYPE_CONTAINING ="ScriptType.findByScriptTypeContaining";
	
    @Id @Column(name="script_type_id" ) 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer scriptTypeId;

//MP-MANAGED-ADDED-AREA-BEGINNING @script_type-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @script_type-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-script_type@
    @Column(name="script_type"  , length=45 , nullable=false , unique=false)
    private String scriptType; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @priceScriptTypeViaScriptTypeId-field-script_type@
    @OneToMany (targetEntity=defaultroot.defautmodel.domain.defautmodel.Price.class, fetch=FetchType.LAZY, mappedBy="scriptTypeId", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <Price> priceScriptTypeViaScriptTypeId = new HashSet<Price>(); 

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @scriptScriptTypeViaScriptTypeId-field-script_type@
    @OneToMany (targetEntity=defaultroot.defautmodel.domain.defautmodel.Script.class, fetch=FetchType.LAZY, mappedBy="scriptTypeId", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <Script> scriptScriptTypeViaScriptTypeId = new HashSet<Script>(); 

//MP-MANAGED-UPDATABLE-ENDING
    /**
    * Default constructor
    */
    public ScriptType() {
    }

	/**
	* All field constructor 
	*/
    public ScriptType(
       Integer scriptTypeId,
       String scriptType) {
	 this(
       scriptTypeId,
       scriptType
	 ,true);
	}
    
	public ScriptType(
       Integer scriptTypeId,
       String scriptType	
    , boolean setRelationship) {
       //primary keys
       setScriptTypeId (scriptTypeId);
       //attributes
       setScriptType (scriptType);
       //parents
    }

	public ScriptType flat() {
	   return new ScriptType(
          getScriptTypeId(),
          getScriptType()
       , false
	   );
	}

    public Integer getScriptTypeId() {
        return scriptTypeId;
    }
	
    public void setScriptTypeId (Integer scriptTypeId) {
        this.scriptTypeId =  scriptTypeId;
    }
    
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-script_type@
    public String getScriptType() {
        return scriptType;
    }
	
    public void setScriptType (String scriptType) {
        this.scriptType =  scriptType;
    }
	
//MP-MANAGED-UPDATABLE-ENDING



//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @priceScriptTypeViaScriptTypeId-getter-script_type@
    public Set<Price> getPriceScriptTypeViaScriptTypeId() {
        if (priceScriptTypeViaScriptTypeId == null){
            priceScriptTypeViaScriptTypeId = new HashSet<Price>();
        }
        return priceScriptTypeViaScriptTypeId;
    }

    public void setPriceScriptTypeViaScriptTypeId (Set<Price> priceScriptTypeViaScriptTypeId) {
        this.priceScriptTypeViaScriptTypeId = priceScriptTypeViaScriptTypeId;
    }	
    
    public void addPriceScriptTypeViaScriptTypeId (Price element) {
    	    getPriceScriptTypeViaScriptTypeId().add(element);
    }
    
//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @scriptScriptTypeViaScriptTypeId-getter-script_type@
    public Set<Script> getScriptScriptTypeViaScriptTypeId() {
        if (scriptScriptTypeViaScriptTypeId == null){
            scriptScriptTypeViaScriptTypeId = new HashSet<Script>();
        }
        return scriptScriptTypeViaScriptTypeId;
    }

    public void setScriptScriptTypeViaScriptTypeId (Set<Script> scriptScriptTypeViaScriptTypeId) {
        this.scriptScriptTypeViaScriptTypeId = scriptScriptTypeViaScriptTypeId;
    }	
    
    public void addScriptScriptTypeViaScriptTypeId (Script element) {
    	    getScriptScriptTypeViaScriptTypeId().add(element);
    }
    
//MP-MANAGED-UPDATABLE-ENDING



//MP-MANAGED-ADDED-AREA-BEGINNING @implementation@
//MP-MANAGED-ADDED-AREA-ENDING @implementation@

}
