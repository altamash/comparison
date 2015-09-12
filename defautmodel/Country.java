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
import defaultroot.defautmodel.domain.defautmodel.CountryTranslate;
import defaultroot.defautmodel.domain.defautmodel.User;

/**
 *
 * <p>Title: Country</p>
 *
 * <p>Description: Domain Object describing a Country entity</p>
 *
 */
@Entity (name="Country")
@Table (name="\"country\"")
@NamedQueries ({
	 @NamedQuery(name="Country.findAll", query="SELECT country FROM Country country")
	,@NamedQuery(name="Country.findByIsoalpha2", query="SELECT country FROM Country country WHERE country.isoalpha2 = :isoalpha2")
	,@NamedQuery(name="Country.findByIsoalpha2Containing", query="SELECT country FROM Country country WHERE country.isoalpha2 like :isoalpha2")

})

public class Country implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String FIND_ALL = "Country.findAll";
    public static final String FIND_BY_ISOALPHA2 = "Country.findByIsoalpha2";
    public static final String FIND_BY_ISOALPHA2_CONTAINING ="Country.findByIsoalpha2Containing";
	
    @Id @Column(name="isoalpha3" ,length=3) 
    private String isoalpha3;

//MP-MANAGED-ADDED-AREA-BEGINNING @isoalpha2-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @isoalpha2-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-isoalpha2@
    @Column(name="isoalpha2"  , length=2 , nullable=false , unique=false)
    private String isoalpha2; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @countryTranslateCountryViaIsoalpha3-field-country@
    @OneToMany (targetEntity=defaultroot.defautmodel.domain.defautmodel.CountryTranslate.class, fetch=FetchType.LAZY, mappedBy="isoalpha3", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <CountryTranslate> countryTranslateCountryViaIsoalpha3 = new HashSet<CountryTranslate>(); 

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @userCountryViaIsoalpha3-field-country@
    @OneToMany (targetEntity=defaultroot.defautmodel.domain.defautmodel.User.class, fetch=FetchType.LAZY, mappedBy="isoalpha3", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <User> userCountryViaIsoalpha3 = new HashSet<User>(); 

//MP-MANAGED-UPDATABLE-ENDING
    /**
    * Default constructor
    */
    public Country() {
    }

	/**
	* All field constructor 
	*/
    public Country(
       String isoalpha3,
       String isoalpha2) {
	 this(
       isoalpha3,
       isoalpha2
	 ,true);
	}
    
	public Country(
       String isoalpha3,
       String isoalpha2	
    , boolean setRelationship) {
       //primary keys
       setIsoalpha3 (isoalpha3);
       //attributes
       setIsoalpha2 (isoalpha2);
       //parents
    }

	public Country flat() {
	   return new Country(
          getIsoalpha3(),
          getIsoalpha2()
       , false
	   );
	}

    public String getIsoalpha3() {
        return isoalpha3;
    }
	
    public void setIsoalpha3 (String isoalpha3) {
        this.isoalpha3 =  isoalpha3;
    }
    
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-isoalpha2@
    public String getIsoalpha2() {
        return isoalpha2;
    }
	
    public void setIsoalpha2 (String isoalpha2) {
        this.isoalpha2 =  isoalpha2;
    }
	
//MP-MANAGED-UPDATABLE-ENDING



//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @countryTranslateCountryViaIsoalpha3-getter-country@
    public Set<CountryTranslate> getCountryTranslateCountryViaIsoalpha3() {
        if (countryTranslateCountryViaIsoalpha3 == null){
            countryTranslateCountryViaIsoalpha3 = new HashSet<CountryTranslate>();
        }
        return countryTranslateCountryViaIsoalpha3;
    }

    public void setCountryTranslateCountryViaIsoalpha3 (Set<CountryTranslate> countryTranslateCountryViaIsoalpha3) {
        this.countryTranslateCountryViaIsoalpha3 = countryTranslateCountryViaIsoalpha3;
    }	
    
    public void addCountryTranslateCountryViaIsoalpha3 (CountryTranslate element) {
    	    getCountryTranslateCountryViaIsoalpha3().add(element);
    }
    
//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @userCountryViaIsoalpha3-getter-country@
    public Set<User> getUserCountryViaIsoalpha3() {
        if (userCountryViaIsoalpha3 == null){
            userCountryViaIsoalpha3 = new HashSet<User>();
        }
        return userCountryViaIsoalpha3;
    }

    public void setUserCountryViaIsoalpha3 (Set<User> userCountryViaIsoalpha3) {
        this.userCountryViaIsoalpha3 = userCountryViaIsoalpha3;
    }	
    
    public void addUserCountryViaIsoalpha3 (User element) {
    	    getUserCountryViaIsoalpha3().add(element);
    }
    
//MP-MANAGED-UPDATABLE-ENDING



//MP-MANAGED-ADDED-AREA-BEGINNING @implementation@
//MP-MANAGED-ADDED-AREA-ENDING @implementation@

}
