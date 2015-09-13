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
import defaultroot.defautmodel.domain.defautmodel.CountryTranslate;
import defaultroot.defautmodel.domain.defautmodel.LanguageSkill;
import defaultroot.defautmodel.domain.defautmodel.LanguageTranslate;
import defaultroot.defautmodel.domain.defautmodel.Price;
import defaultroot.defautmodel.domain.defautmodel.Script;
import defaultroot.defautmodel.domain.defautmodel.Translation;
import defaultroot.defautmodel.domain.defautmodel.Translation;
import defaultroot.defautmodel.domain.defautmodel.User;

/**
 *
 * <p>Title: Language</p>
 *
 * <p>Description: Domain Object describing a Language entity</p>
 *
 */
@Entity (name="Language")
@Table (name="\"language\"")
@NamedQueries ({
	 @NamedQuery(name="Language.findAll", query="SELECT language FROM Language language")
	,@NamedQuery(name="Language.findByIso6392b", query="SELECT language FROM Language language WHERE language.iso6392b = :iso6392b")
	,@NamedQuery(name="Language.findByIso6392bContaining", query="SELECT language FROM Language language WHERE language.iso6392b like :iso6392b")

	,@NamedQuery(name="Language.findByIso6391", query="SELECT language FROM Language language WHERE language.iso6391 = :iso6391")
	,@NamedQuery(name="Language.findByIso6391Containing", query="SELECT language FROM Language language WHERE language.iso6391 like :iso6391")

	,@NamedQuery(name="Language.findByIsActive", query="SELECT language FROM Language language WHERE language.isActive = :isActive")

})

public class Language implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String FIND_ALL = "Language.findAll";
    public static final String FIND_BY_ISO6392B = "Language.findByIso6392b";
    public static final String FIND_BY_ISO6392B_CONTAINING ="Language.findByIso6392bContaining";
    public static final String FIND_BY_ISO6391 = "Language.findByIso6391";
    public static final String FIND_BY_ISO6391_CONTAINING ="Language.findByIso6391Containing";
    public static final String FIND_BY_ISACTIVE = "Language.findByIsActive";
	
    @Id @Column(name="iso6392t" ,length=3) 
    private String iso6392t;

//MP-MANAGED-ADDED-AREA-BEGINNING @iso6392b-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @iso6392b-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-iso6392b@
    @Column(name="iso6392b"  , length=3 , nullable=false , unique=false)
    private String iso6392b; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @iso6391-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @iso6391-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-iso6391@
    @Column(name="iso6391"  , length=2 , nullable=true , unique=false)
    private String iso6391; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @is_active-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @is_active-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-is_active@
    @Column(name="is_active"   , nullable=false , unique=false)
    private Boolean isActive; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @countryTranslateLanguageViaForIso6392t-field-language@
    @OneToMany (targetEntity=defaultroot.defautmodel.domain.defautmodel.CountryTranslate.class, fetch=FetchType.LAZY, mappedBy="forIso6392t", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <CountryTranslate> countryTranslateLanguageViaForIso6392t = new HashSet<CountryTranslate>(); 

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @languageSkillLanguageViaIso6392t-field-language@
    @OneToMany (targetEntity=defaultroot.defautmodel.domain.defautmodel.LanguageSkill.class, fetch=FetchType.LAZY, mappedBy="iso6392t", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <LanguageSkill> languageSkillLanguageViaIso6392t = new HashSet<LanguageSkill>(); 

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @languageTranslateLanguageViaIso6392t-field-language@
    @OneToMany (targetEntity=defaultroot.defautmodel.domain.defautmodel.LanguageTranslate.class, fetch=FetchType.LAZY, mappedBy="iso6392t", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <LanguageTranslate> languageTranslateLanguageViaIso6392t = new HashSet<LanguageTranslate>(); 

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @priceLanguageViaIso6392t-field-language@
    @OneToMany (targetEntity=defaultroot.defautmodel.domain.defautmodel.Price.class, fetch=FetchType.LAZY, mappedBy="iso6392t", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <Price> priceLanguageViaIso6392t = new HashSet<Price>(); 

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @scriptLanguageViaIso6392t-field-language@
    @OneToMany (targetEntity=defaultroot.defautmodel.domain.defautmodel.Script.class, fetch=FetchType.LAZY, mappedBy="iso6392t", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <Script> scriptLanguageViaIso6392t = new HashSet<Script>(); 

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @translationLanguageViaIso6392tFrom-field-language@
    @OneToMany (targetEntity=defaultroot.defautmodel.domain.defautmodel.Translation.class, fetch=FetchType.LAZY, mappedBy="iso6392tFrom", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <Translation> translationLanguageViaIso6392tFrom = new HashSet<Translation>(); 

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @translationLanguageViaIso6392tTo-field-language@
    @OneToMany (targetEntity=defaultroot.defautmodel.domain.defautmodel.Translation.class, fetch=FetchType.LAZY, mappedBy="iso6392tTo", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <Translation> translationLanguageViaIso6392tTo = new HashSet<Translation>(); 

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @userLanguageViaAppLanguage-field-language@
    @OneToMany (targetEntity=defaultroot.defautmodel.domain.defautmodel.User.class, fetch=FetchType.LAZY, mappedBy="appLanguage", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <User> userLanguageViaAppLanguage = new HashSet<User>(); 

//MP-MANAGED-UPDATABLE-ENDING
    /**
    * Default constructor
    */
    public Language() {
    }

	/**
	* All field constructor 
	*/
    public Language(
       String iso6392t,
       String iso6392b,
       String iso6391,
       Boolean isActive) {
	 this(
       iso6392t,
       iso6392b,
       iso6391,
       isActive
	 ,true);
	}
    
	public Language(
       String iso6392t,
       String iso6392b,
       String iso6391,
       Boolean isActive	
    , boolean setRelationship) {
       //primary keys
       setIso6392t (iso6392t);
       //attributes
       setIso6392b (iso6392b);
       setIso6391 (iso6391);
       setIsActive (isActive);
       //parents
    }

	public Language flat() {
	   return new Language(
          getIso6392t(),
          getIso6392b(),
          getIso6391(),
          getIsActive()
       , false
	   );
	}

    public String getIso6392t() {
        return iso6392t;
    }
	
    public void setIso6392t (String iso6392t) {
        this.iso6392t =  iso6392t;
    }
    
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-iso6392b@
    public String getIso6392b() {
        return iso6392b;
    }
	
    public void setIso6392b (String iso6392b) {
        this.iso6392b =  iso6392b;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-iso6391@
    public String getIso6391() {
        return iso6391;
    }
	
    public void setIso6391 (String iso6391) {
        this.iso6391 =  iso6391;
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



//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @countryTranslateLanguageViaForIso6392t-getter-language@
    public Set<CountryTranslate> getCountryTranslateLanguageViaForIso6392t() {
        if (countryTranslateLanguageViaForIso6392t == null){
            countryTranslateLanguageViaForIso6392t = new HashSet<CountryTranslate>();
        }
        return countryTranslateLanguageViaForIso6392t;
    }

    public void setCountryTranslateLanguageViaForIso6392t (Set<CountryTranslate> countryTranslateLanguageViaForIso6392t) {
        this.countryTranslateLanguageViaForIso6392t = countryTranslateLanguageViaForIso6392t;
    }	
    
    public void addCountryTranslateLanguageViaForIso6392t (CountryTranslate element) {
    	    getCountryTranslateLanguageViaForIso6392t().add(element);
    }
    
//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @languageSkillLanguageViaIso6392t-getter-language@
    public Set<LanguageSkill> getLanguageSkillLanguageViaIso6392t() {
        if (languageSkillLanguageViaIso6392t == null){
            languageSkillLanguageViaIso6392t = new HashSet<LanguageSkill>();
        }
        return languageSkillLanguageViaIso6392t;
    }

    public void setLanguageSkillLanguageViaIso6392t (Set<LanguageSkill> languageSkillLanguageViaIso6392t) {
        this.languageSkillLanguageViaIso6392t = languageSkillLanguageViaIso6392t;
    }	
    
    public void addLanguageSkillLanguageViaIso6392t (LanguageSkill element) {
    	    getLanguageSkillLanguageViaIso6392t().add(element);
    }
    
//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @languageTranslateLanguageViaIso6392t-getter-language@
    public Set<LanguageTranslate> getLanguageTranslateLanguageViaIso6392t() {
        if (languageTranslateLanguageViaIso6392t == null){
            languageTranslateLanguageViaIso6392t = new HashSet<LanguageTranslate>();
        }
        return languageTranslateLanguageViaIso6392t;
    }

    public void setLanguageTranslateLanguageViaIso6392t (Set<LanguageTranslate> languageTranslateLanguageViaIso6392t) {
        this.languageTranslateLanguageViaIso6392t = languageTranslateLanguageViaIso6392t;
    }	
    
    public void addLanguageTranslateLanguageViaIso6392t (LanguageTranslate element) {
    	    getLanguageTranslateLanguageViaIso6392t().add(element);
    }
    
//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @priceLanguageViaIso6392t-getter-language@
    public Set<Price> getPriceLanguageViaIso6392t() {
        if (priceLanguageViaIso6392t == null){
            priceLanguageViaIso6392t = new HashSet<Price>();
        }
        return priceLanguageViaIso6392t;
    }

    public void setPriceLanguageViaIso6392t (Set<Price> priceLanguageViaIso6392t) {
        this.priceLanguageViaIso6392t = priceLanguageViaIso6392t;
    }	
    
    public void addPriceLanguageViaIso6392t (Price element) {
    	    getPriceLanguageViaIso6392t().add(element);
    }
    
//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @scriptLanguageViaIso6392t-getter-language@
    public Set<Script> getScriptLanguageViaIso6392t() {
        if (scriptLanguageViaIso6392t == null){
            scriptLanguageViaIso6392t = new HashSet<Script>();
        }
        return scriptLanguageViaIso6392t;
    }

    public void setScriptLanguageViaIso6392t (Set<Script> scriptLanguageViaIso6392t) {
        this.scriptLanguageViaIso6392t = scriptLanguageViaIso6392t;
    }	
    
    public void addScriptLanguageViaIso6392t (Script element) {
    	    getScriptLanguageViaIso6392t().add(element);
    }
    
//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @translationLanguageViaIso6392tFrom-getter-language@
    public Set<Translation> getTranslationLanguageViaIso6392tFrom() {
        if (translationLanguageViaIso6392tFrom == null){
            translationLanguageViaIso6392tFrom = new HashSet<Translation>();
        }
        return translationLanguageViaIso6392tFrom;
    }

    public void setTranslationLanguageViaIso6392tFrom (Set<Translation> translationLanguageViaIso6392tFrom) {
        this.translationLanguageViaIso6392tFrom = translationLanguageViaIso6392tFrom;
    }	
    
    public void addTranslationLanguageViaIso6392tFrom (Translation element) {
    	    getTranslationLanguageViaIso6392tFrom().add(element);
    }
    
//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @translationLanguageViaIso6392tTo-getter-language@
    public Set<Translation> getTranslationLanguageViaIso6392tTo() {
        if (translationLanguageViaIso6392tTo == null){
            translationLanguageViaIso6392tTo = new HashSet<Translation>();
        }
        return translationLanguageViaIso6392tTo;
    }

    public void setTranslationLanguageViaIso6392tTo (Set<Translation> translationLanguageViaIso6392tTo) {
        this.translationLanguageViaIso6392tTo = translationLanguageViaIso6392tTo;
    }	
    
    public void addTranslationLanguageViaIso6392tTo (Translation element) {
    	    getTranslationLanguageViaIso6392tTo().add(element);
    }
    
//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @userLanguageViaAppLanguage-getter-language@
    public Set<User> getUserLanguageViaAppLanguage() {
        if (userLanguageViaAppLanguage == null){
            userLanguageViaAppLanguage = new HashSet<User>();
        }
        return userLanguageViaAppLanguage;
    }

    public void setUserLanguageViaAppLanguage (Set<User> userLanguageViaAppLanguage) {
        this.userLanguageViaAppLanguage = userLanguageViaAppLanguage;
    }	
    
    public void addUserLanguageViaAppLanguage (User element) {
    	    getUserLanguageViaAppLanguage().add(element);
    }
    
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @prepersist-language@
    @javax.persistence.PrePersist
    public void prePersist_ () {
    }
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @preupdate-language@
    @javax.persistence.PreUpdate
    public void preUpdate_ () {
    }
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @implementation@
//MP-MANAGED-ADDED-AREA-ENDING @implementation@

}
