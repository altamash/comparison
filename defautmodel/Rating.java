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
	* - time      : 2015/08/04 AD at 17:45:43 PKT
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
import defaultroot.defautmodel.domain.defautmodel.Script;
import defaultroot.defautmodel.domain.defautmodel.Script;

/**
 *
 * <p>Title: Rating</p>
 *
 * <p>Description: Domain Object describing a Rating entity</p>
 *
 */
@Entity (name="Rating")
@Table (name="\"rating\"")
@NamedQueries ({
	 @NamedQuery(name="Rating.findAll", query="SELECT rating FROM Rating rating")
	,@NamedQuery(name="Rating.findByRating", query="SELECT rating FROM Rating rating WHERE rating.rating = :rating")

})

public class Rating implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String FIND_ALL = "Rating.findAll";
    public static final String FIND_BY_RATING = "Rating.findByRating";
	
    @Id @Column(name="rating_id" ) 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer ratingId;

//MP-MANAGED-ADDED-AREA-BEGINNING @rating-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @rating-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-rating@
    @Column(name="rating"   , nullable=true , unique=false)
    private Integer rating; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @priceRatingViaRatingId-field-rating@
    @OneToMany (targetEntity=defaultroot.defautmodel.domain.defautmodel.Price.class, fetch=FetchType.LAZY, mappedBy="ratingId", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <Price> priceRatingViaRatingId = new HashSet<Price>(); 

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @scriptRatingViaRatingIdRequest-field-rating@
    @OneToMany (targetEntity=defaultroot.defautmodel.domain.defautmodel.Script.class, fetch=FetchType.LAZY, mappedBy="ratingIdRequest", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <Script> scriptRatingViaRatingIdRequest = new HashSet<Script>(); 

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @scriptRatingViaRatingIdScriptor-field-rating@
    @OneToMany (targetEntity=defaultroot.defautmodel.domain.defautmodel.Script.class, fetch=FetchType.LAZY, mappedBy="ratingIdScriptor", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <Script> scriptRatingViaRatingIdScriptor = new HashSet<Script>(); 

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @scriptRatingViaRatingIdClient-field-rating@
    @OneToMany (targetEntity=defaultroot.defautmodel.domain.defautmodel.Script.class, fetch=FetchType.LAZY, mappedBy="ratingIdClient", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <Script> scriptRatingViaRatingIdClient = new HashSet<Script>(); 

//MP-MANAGED-UPDATABLE-ENDING
    /**
    * Default constructor
    */
    public Rating() {
    }

	/**
	* All field constructor 
	*/
    public Rating(
       Integer ratingId,
       Integer rating) {
	 this(
       ratingId,
       rating
	 ,true);
	}
    
	public Rating(
       Integer ratingId,
       Integer rating	
    , boolean setRelationship) {
       //primary keys
       setRatingId (ratingId);
       //attributes
       setRating (rating);
       //parents
    }

	public Rating flat() {
	   return new Rating(
          getRatingId(),
          getRating()
       , false
	   );
	}

    public Integer getRatingId() {
        return ratingId;
    }
	
    public void setRatingId (Integer ratingId) {
        this.ratingId =  ratingId;
    }
    
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-rating@
    public Integer getRating() {
        return rating;
    }
	
    public void setRating (Integer rating) {
        this.rating =  rating;
    }
	
//MP-MANAGED-UPDATABLE-ENDING



//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @priceRatingViaRatingId-getter-rating@
    public Set<Price> getPriceRatingViaRatingId() {
        if (priceRatingViaRatingId == null){
            priceRatingViaRatingId = new HashSet<Price>();
        }
        return priceRatingViaRatingId;
    }

    public void setPriceRatingViaRatingId (Set<Price> priceRatingViaRatingId) {
        this.priceRatingViaRatingId = priceRatingViaRatingId;
    }	
    
    public void addPriceRatingViaRatingId (Price element) {
    	    getPriceRatingViaRatingId().add(element);
    }
    
//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @scriptRatingViaRatingIdRequest-getter-rating@
    public Set<Script> getScriptRatingViaRatingIdRequest() {
        if (scriptRatingViaRatingIdRequest == null){
            scriptRatingViaRatingIdRequest = new HashSet<Script>();
        }
        return scriptRatingViaRatingIdRequest;
    }

    public void setScriptRatingViaRatingIdRequest (Set<Script> scriptRatingViaRatingIdRequest) {
        this.scriptRatingViaRatingIdRequest = scriptRatingViaRatingIdRequest;
    }	
    
    public void addScriptRatingViaRatingIdRequest (Script element) {
    	    getScriptRatingViaRatingIdRequest().add(element);
    }
    
//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @scriptRatingViaRatingIdScriptor-getter-rating@
    public Set<Script> getScriptRatingViaRatingIdScriptor() {
        if (scriptRatingViaRatingIdScriptor == null){
            scriptRatingViaRatingIdScriptor = new HashSet<Script>();
        }
        return scriptRatingViaRatingIdScriptor;
    }

    public void setScriptRatingViaRatingIdScriptor (Set<Script> scriptRatingViaRatingIdScriptor) {
        this.scriptRatingViaRatingIdScriptor = scriptRatingViaRatingIdScriptor;
    }	
    
    public void addScriptRatingViaRatingIdScriptor (Script element) {
    	    getScriptRatingViaRatingIdScriptor().add(element);
    }
    
//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @scriptRatingViaRatingIdClient-getter-rating@
    public Set<Script> getScriptRatingViaRatingIdClient() {
        if (scriptRatingViaRatingIdClient == null){
            scriptRatingViaRatingIdClient = new HashSet<Script>();
        }
        return scriptRatingViaRatingIdClient;
    }

    public void setScriptRatingViaRatingIdClient (Set<Script> scriptRatingViaRatingIdClient) {
        this.scriptRatingViaRatingIdClient = scriptRatingViaRatingIdClient;
    }	
    
    public void addScriptRatingViaRatingIdClient (Script element) {
    	    getScriptRatingViaRatingIdClient().add(element);
    }
    
//MP-MANAGED-UPDATABLE-ENDING



//MP-MANAGED-ADDED-AREA-BEGINNING @implementation@
//MP-MANAGED-ADDED-AREA-ENDING @implementation@

}
