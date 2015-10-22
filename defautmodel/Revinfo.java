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

/**
 *
 * <p>Title: Revinfo</p>
 *
 * <p>Description: Domain Object describing a Revinfo entity</p>
 *
 */
@Entity (name="Revinfo")
@Table (name="\"revinfo\"")
@NamedQueries ({
	 @NamedQuery(name="Revinfo.findAll", query="SELECT revinfo FROM Revinfo revinfo")
	,@NamedQuery(name="Revinfo.findByCreatedAt", query="SELECT revinfo FROM Revinfo revinfo WHERE revinfo.createdAt = :createdAt")

})

public class Revinfo implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String FIND_ALL = "Revinfo.findAll";
    public static final String FIND_BY_CREATEDAT = "Revinfo.findByCreatedAt";
	
    @Id @Column(name="revinfo_id" ) 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer revinfoId;

//MP-MANAGED-ADDED-AREA-BEGINNING @created_at-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @created_at-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-created_at@
    @Column(name="created_at"   , nullable=false , unique=true)
    private Long createdAt; 
//MP-MANAGED-UPDATABLE-ENDING

    /**
    * Default constructor
    */
    public Revinfo() {
    }

	/**
	* All field constructor 
	*/
    public Revinfo(
       Integer revinfoId,
       Long createdAt) {
	 this(
       revinfoId,
       createdAt
	 ,true);
	}
    
	public Revinfo(
       Integer revinfoId,
       Long createdAt	
    , boolean setRelationship) {
       //primary keys
       setRevinfoId (revinfoId);
       //attributes
       setCreatedAt (createdAt);
       //parents
    }

	public Revinfo flat() {
	   return new Revinfo(
          getRevinfoId(),
          getCreatedAt()
       , false
	   );
	}

    public Integer getRevinfoId() {
        return revinfoId;
    }
	
    public void setRevinfoId (Integer revinfoId) {
        this.revinfoId =  revinfoId;
    }
    
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-created_at@
    public Long getCreatedAt() {
        return createdAt;
    }
	
    public void setCreatedAt (Long createdAt) {
        this.createdAt =  createdAt;
    }
	
//MP-MANAGED-UPDATABLE-ENDING






//MP-MANAGED-ADDED-AREA-BEGINNING @implementation@
//MP-MANAGED-ADDED-AREA-ENDING @implementation@

}
