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
import defaultroot.defautmodel.domain.defautmodel.Language;
import defaultroot.defautmodel.domain.defautmodel.Country;
import defaultroot.defautmodel.domain.defautmodel.CountryTranslateId;

/**
 *
 * <p>Title: CountryTranslate</p>
 *
 * <p>Description: Domain Object describing a CountryTranslate entity</p>
 *
 */
@Entity (name="CountryTranslate")
@Table (name="\"country_translate\"")
@NamedQueries ({
	 @NamedQuery(name="CountryTranslate.findAll", query="SELECT countrytranslate FROM CountryTranslate countrytranslate")
	,@NamedQuery(name="CountryTranslate.findByCountryName", query="SELECT countrytranslate FROM CountryTranslate countrytranslate WHERE countrytranslate.countryName = :countryName")
	,@NamedQuery(name="CountryTranslate.findByCountryNameContaining", query="SELECT countrytranslate FROM CountryTranslate countrytranslate WHERE countrytranslate.countryName like :countryName")

})

public class CountryTranslate implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String FIND_ALL = "CountryTranslate.findAll";
    public static final String FIND_BY_COUNTRYNAME = "CountryTranslate.findByCountryName";
    public static final String FIND_BY_COUNTRYNAME_CONTAINING ="CountryTranslate.findByCountryNameContaining";
	
    @EmbeddedId
    private CountryTranslateId countryTranslateId__;
//MP-MANAGED-ADDED-AREA-BEGINNING @country_name-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @country_name-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-country_name@
    @Column(name="country_name"  , length=100 , nullable=false , unique=false)
    private String countryName; 
//MP-MANAGED-UPDATABLE-ENDING

    @MapsId ("for_iso6392t")
    @ManyToOne (fetch=FetchType.LAZY , optional=false)
    @JoinColumn(name="for_iso6392t", referencedColumnName = "iso6392t" , nullable=false , unique=false , insertable=true, updatable=true) 
    private Language forIso6392t;  

    @Column(name="for_iso6392t" , length=3 , nullable=false , unique=true, insertable=false, updatable=false)
    private String forIso6392t_;

    @MapsId ("isoalpha3")
    @ManyToOne (fetch=FetchType.LAZY , optional=false)
    @JoinColumn(name="isoalpha3", referencedColumnName = "isoalpha3" , nullable=false , unique=true  , insertable=true, updatable=true) 
    private Country isoalpha3;  

    @Column(name="isoalpha3" , length=3 , nullable=false , unique=true, insertable=false, updatable=false)
    private String isoalpha3_;

    /**
    * Default constructor
    */
    public CountryTranslate() {
    }

	/**
	* All field constructor 
	*/
    public CountryTranslate(
       String isoalpha3,
       String countryName,
       String forIso6392t) {
	 this(
       isoalpha3,
       countryName,
       forIso6392t
	 ,true);
	}
    
	public CountryTranslate(
       String isoalpha3,
       String countryName,
       String forIso6392t	
    , boolean setRelationship) {
       //primary keys
       this.countryTranslateId__ = new CountryTranslateId();  	
       //attributes
       setCountryName (countryName);
       //parents
       if (setRelationship) this.forIso6392t = new Language();
       if (setRelationship) this.forIso6392t.setIso6392t(forIso6392t); 
	   setForIso6392t_ (forIso6392t);
       if (setRelationship) this.isoalpha3 = new Country();
       if (setRelationship) this.isoalpha3.setIsoalpha3(isoalpha3); 
	   setIsoalpha3_ (isoalpha3);
    }

	public CountryTranslate flat() {
	   return new CountryTranslate(
		  getCountryTranslateId__().getIsoalpha3(),
          getCountryName(),
		  getCountryTranslateId__().getForIso6392t()
       , false
	   );
	}


    public CountryTranslateId getCountryTranslateId__() {
		if (countryTranslateId__==null) countryTranslateId__ = new CountryTranslateId();
        return countryTranslateId__;
    }
	
    public void setCountryTranslateId__ (CountryTranslateId countryTranslateId__) {
        this.countryTranslateId__ =  countryTranslateId__;
    }
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-country_name@
    public String getCountryName() {
        return countryName;
    }
	
    public void setCountryName (String countryName) {
        this.countryName =  countryName;
    }
	
//MP-MANAGED-UPDATABLE-ENDING


    public Language getForIso6392t () {
    	return forIso6392t;
    }
	
    public void setForIso6392t (Language forIso6392t) {
    	this.forIso6392t = forIso6392t;
    }

    public String getForIso6392t_() {
        return forIso6392t_;
    }
	
    public void setForIso6392t_ (String forIso6392t) {
        this.forIso6392t_ =  forIso6392t;
    }
	
    public Country getIsoalpha3 () {
    	return isoalpha3;
    }
	
    public void setIsoalpha3 (Country isoalpha3) {
    	this.isoalpha3 = isoalpha3;
    }

    public String getIsoalpha3_() {
        return isoalpha3_;
    }
	
    public void setIsoalpha3_ (String isoalpha3) {
        this.isoalpha3_ =  isoalpha3;
    }
	




//MP-MANAGED-ADDED-AREA-BEGINNING @implementation@
//MP-MANAGED-ADDED-AREA-ENDING @implementation@

}
