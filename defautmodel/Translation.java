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
import defaultroot.defautmodel.domain.defautmodel.TranslationSkill;
import defaultroot.defautmodel.domain.defautmodel.Language;
import defaultroot.defautmodel.domain.defautmodel.Language;

/**
 *
 * <p>Title: Translation</p>
 *
 * <p>Description: Domain Object describing a Translation entity</p>
 *
 */
@Entity (name="Translation")
@Table (name="\"translation\"")
@NamedQueries ({
	 @NamedQuery(name="Translation.findAll", query="SELECT translation FROM Translation translation")
	,@NamedQuery(name="Translation.findByAmountSkill", query="SELECT translation FROM Translation translation WHERE translation.amountSkill = :amountSkill")

	,@NamedQuery(name="Translation.findByIsActive", query="SELECT translation FROM Translation translation WHERE translation.isActive = :isActive")

})

public class Translation implements Serializable {
    private static final long serialVersionUID = 1L;
	public static final Integer __DEFAULT_AMOUNT_SKILL = Integer.valueOf(0);

    public static final String FIND_ALL = "Translation.findAll";
    public static final String FIND_BY_AMOUNTSKILL = "Translation.findByAmountSkill";
    public static final String FIND_BY_ISACTIVE = "Translation.findByIsActive";
	
    @Id @Column(name="translation_id" ) 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer translationId;

//MP-MANAGED-ADDED-AREA-BEGINNING @amount_skill-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @amount_skill-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-amount_skill@
    @Column(name="amount_skill"   , nullable=false , unique=false)
    private Integer amountSkill; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @is_active-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @is_active-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-is_active@
    @Column(name="is_active"   , nullable=false , unique=false)
    private Boolean isActive; 
//MP-MANAGED-UPDATABLE-ENDING

    @ManyToOne (fetch=FetchType.LAZY , optional=false)
    @JoinColumn(name="iso6392t_from", referencedColumnName = "iso6392t" , nullable=false , unique=false , insertable=true, updatable=true) 
    private Language iso6392tFrom;  

    @Column(name="iso6392t_from" , length=3 , nullable=false , unique=true, insertable=false, updatable=false)
    private String iso6392tFrom_;

    @ManyToOne (fetch=FetchType.LAZY , optional=false)
    @JoinColumn(name="iso6392t_to", referencedColumnName = "iso6392t" , nullable=false , unique=true  , insertable=true, updatable=true) 
    private Language iso6392tTo;  

    @Column(name="iso6392t_to" , length=3 , nullable=false , unique=true, insertable=false, updatable=false)
    private String iso6392tTo_;

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @priceTranslationViaTranslationId-field-translation@
    @OneToMany (targetEntity=defaultroot.defautmodel.domain.defautmodel.Price.class, fetch=FetchType.LAZY, mappedBy="translationId", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <Price> priceTranslationViaTranslationId = new HashSet<Price>(); 

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @scriptTranslationViaTranslationId-field-translation@
    @OneToMany (targetEntity=defaultroot.defautmodel.domain.defautmodel.Script.class, fetch=FetchType.LAZY, mappedBy="translationId", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <Script> scriptTranslationViaTranslationId = new HashSet<Script>(); 

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @translationSkillTranslationViaTranslationId-field-translation@
    @OneToMany (targetEntity=defaultroot.defautmodel.domain.defautmodel.TranslationSkill.class, fetch=FetchType.LAZY, mappedBy="translationId", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <TranslationSkill> translationSkillTranslationViaTranslationId = new HashSet<TranslationSkill>(); 

//MP-MANAGED-UPDATABLE-ENDING
    /**
    * Default constructor
    */
    public Translation() {
    }

	/**
	* All field constructor 
	*/
    public Translation(
       Integer translationId,
       String iso6392tFrom,
       String iso6392tTo,
       Integer amountSkill,
       Boolean isActive) {
	 this(
       translationId,
       iso6392tFrom,
       iso6392tTo,
       amountSkill,
       isActive
	 ,true);
	}
    
	public Translation(
       Integer translationId,
       String iso6392tFrom,
       String iso6392tTo,
       Integer amountSkill,
       Boolean isActive	
    , boolean setRelationship) {
       //primary keys
       setTranslationId (translationId);
       //attributes
       setAmountSkill (amountSkill);
       setIsActive (isActive);
       //parents
       if (setRelationship) this.iso6392tFrom = new Language();
       if (setRelationship) this.iso6392tFrom.setIso6392t(iso6392tFrom); 
	   setIso6392tFrom_ (iso6392tFrom);
       if (setRelationship) this.iso6392tTo = new Language();
       if (setRelationship) this.iso6392tTo.setIso6392t(iso6392tTo); 
	   setIso6392tTo_ (iso6392tTo);
    }

	public Translation flat() {
	   return new Translation(
          getTranslationId(),
          getIso6392tFrom_(),
          getIso6392tTo_(),
          getAmountSkill(),
          getIsActive()
       , false
	   );
	}

    public Integer getTranslationId() {
        return translationId;
    }
	
    public void setTranslationId (Integer translationId) {
        this.translationId =  translationId;
    }
    
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-amount_skill@
    public Integer getAmountSkill() {
        return amountSkill;
    }
	
    public void setAmountSkill (Integer amountSkill) {
        this.amountSkill =  amountSkill;
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


    public Language getIso6392tFrom () {
    	return iso6392tFrom;
    }
	
    public void setIso6392tFrom (Language iso6392tFrom) {
    	this.iso6392tFrom = iso6392tFrom;
    }

    public String getIso6392tFrom_() {
        return iso6392tFrom_;
    }
	
    public void setIso6392tFrom_ (String iso6392tFrom) {
        this.iso6392tFrom_ =  iso6392tFrom;
    }
	
    public Language getIso6392tTo () {
    	return iso6392tTo;
    }
	
    public void setIso6392tTo (Language iso6392tTo) {
    	this.iso6392tTo = iso6392tTo;
    }

    public String getIso6392tTo_() {
        return iso6392tTo_;
    }
	
    public void setIso6392tTo_ (String iso6392tTo) {
        this.iso6392tTo_ =  iso6392tTo;
    }
	

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @priceTranslationViaTranslationId-getter-translation@
    public Set<Price> getPriceTranslationViaTranslationId() {
        if (priceTranslationViaTranslationId == null){
            priceTranslationViaTranslationId = new HashSet<Price>();
        }
        return priceTranslationViaTranslationId;
    }

    public void setPriceTranslationViaTranslationId (Set<Price> priceTranslationViaTranslationId) {
        this.priceTranslationViaTranslationId = priceTranslationViaTranslationId;
    }	
    
    public void addPriceTranslationViaTranslationId (Price element) {
    	    getPriceTranslationViaTranslationId().add(element);
    }
    
//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @scriptTranslationViaTranslationId-getter-translation@
    public Set<Script> getScriptTranslationViaTranslationId() {
        if (scriptTranslationViaTranslationId == null){
            scriptTranslationViaTranslationId = new HashSet<Script>();
        }
        return scriptTranslationViaTranslationId;
    }

    public void setScriptTranslationViaTranslationId (Set<Script> scriptTranslationViaTranslationId) {
        this.scriptTranslationViaTranslationId = scriptTranslationViaTranslationId;
    }	
    
    public void addScriptTranslationViaTranslationId (Script element) {
    	    getScriptTranslationViaTranslationId().add(element);
    }
    
//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @translationSkillTranslationViaTranslationId-getter-translation@
    public Set<TranslationSkill> getTranslationSkillTranslationViaTranslationId() {
        if (translationSkillTranslationViaTranslationId == null){
            translationSkillTranslationViaTranslationId = new HashSet<TranslationSkill>();
        }
        return translationSkillTranslationViaTranslationId;
    }

    public void setTranslationSkillTranslationViaTranslationId (Set<TranslationSkill> translationSkillTranslationViaTranslationId) {
        this.translationSkillTranslationViaTranslationId = translationSkillTranslationViaTranslationId;
    }	
    
    public void addTranslationSkillTranslationViaTranslationId (TranslationSkill element) {
    	    getTranslationSkillTranslationViaTranslationId().add(element);
    }
    
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @prepersist-translation@
    @javax.persistence.PrePersist
    public void prePersist_ () {
        if (amountSkill==null) amountSkill=__DEFAULT_AMOUNT_SKILL;
    }
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @preupdate-translation@
    @javax.persistence.PreUpdate
    public void preUpdate_ () {
        if (amountSkill==null) amountSkill=__DEFAULT_AMOUNT_SKILL;
    }
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @implementation@
//MP-MANAGED-ADDED-AREA-ENDING @implementation@

}
