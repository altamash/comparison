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
import defaultroot.defautmodel.domain.defautmodel.Language;
import defaultroot.defautmodel.domain.defautmodel.User;
import defaultroot.defautmodel.domain.defautmodel.LanguageSkillId;

/**
 *
 * <p>Title: LanguageSkill</p>
 *
 * <p>Description: Domain Object describing a LanguageSkill entity</p>
 *
 */
@Entity (name="LanguageSkill")
@Table (name="\"language_skill\"")
@NamedQueries ({
	 @NamedQuery(name="LanguageSkill.findAll", query="SELECT languageskill FROM LanguageSkill languageskill")
	,@NamedQuery(name="LanguageSkill.findByMotherTongue", query="SELECT languageskill FROM LanguageSkill languageskill WHERE languageskill.motherTongue = :motherTongue")

	,@NamedQuery(name="LanguageSkill.findByRatingAverage", query="SELECT languageskill FROM LanguageSkill languageskill WHERE languageskill.ratingAverage = :ratingAverage")

	,@NamedQuery(name="LanguageSkill.findByScriptAmount", query="SELECT languageskill FROM LanguageSkill languageskill WHERE languageskill.scriptAmount = :scriptAmount")

	,@NamedQuery(name="LanguageSkill.findByIsSupervisor", query="SELECT languageskill FROM LanguageSkill languageskill WHERE languageskill.isSupervisor = :isSupervisor")

})

public class LanguageSkill implements Serializable {
    private static final long serialVersionUID = 1L;
	public static final Long __DEFAULT_RATING_AVERAGE = Long.valueOf(0);
	public static final Integer __DEFAULT_SCRIPT_AMOUNT = Integer.valueOf(0);

    public static final String FIND_ALL = "LanguageSkill.findAll";
    public static final String FIND_BY_MOTHERTONGUE = "LanguageSkill.findByMotherTongue";
    public static final String FIND_BY_RATINGAVERAGE = "LanguageSkill.findByRatingAverage";
    public static final String FIND_BY_SCRIPTAMOUNT = "LanguageSkill.findByScriptAmount";
    public static final String FIND_BY_ISSUPERVISOR = "LanguageSkill.findByIsSupervisor";
	
    @EmbeddedId
    private LanguageSkillId languageSkillId__;
//MP-MANAGED-ADDED-AREA-BEGINNING @mother_tongue-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @mother_tongue-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-mother_tongue@
    @Column(name="mother_tongue"   , nullable=false , unique=false)
    private Boolean motherTongue; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @rating_average-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @rating_average-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-rating_average@
    @Column(name="rating_average"   , nullable=false , unique=true)
    private Long ratingAverage; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @script_amount-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @script_amount-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-script_amount@
    @Column(name="script_amount"   , nullable=false , unique=false)
    private Integer scriptAmount; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @is_supervisor-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @is_supervisor-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-is_supervisor@
    @Column(name="is_supervisor"   , nullable=false , unique=false)
    private Boolean isSupervisor; 
//MP-MANAGED-UPDATABLE-ENDING

    @MapsId ("iso6392t")
    @ManyToOne (fetch=FetchType.LAZY , optional=false)
    @JoinColumn(name="iso6392t", referencedColumnName = "iso6392t" , nullable=false , unique=false , insertable=true, updatable=true) 
    private Language iso6392t;  

    @Column(name="iso6392t" , length=3 , nullable=false , unique=true, insertable=false, updatable=false)
    private String iso6392t_;

    @MapsId ("user_id")
    @ManyToOne (fetch=FetchType.LAZY , optional=false)
    @JoinColumn(name="user_id", referencedColumnName = "user_id" , nullable=false , unique=true  , insertable=true, updatable=true) 
    private User userId;  

    @Column(name="user_id"  , nullable=false , unique=true, insertable=false, updatable=false)
    private Integer userId_;

    /**
    * Default constructor
    */
    public LanguageSkill() {
    }

	/**
	* All field constructor 
	*/
    public LanguageSkill(
       Integer userId,
       String iso6392t,
       Boolean motherTongue,
       Long ratingAverage,
       Integer scriptAmount,
       Boolean isSupervisor) {
	 this(
       userId,
       iso6392t,
       motherTongue,
       ratingAverage,
       scriptAmount,
       isSupervisor
	 ,true);
	}
    
	public LanguageSkill(
       Integer userId,
       String iso6392t,
       Boolean motherTongue,
       Long ratingAverage,
       Integer scriptAmount,
       Boolean isSupervisor	
    , boolean setRelationship) {
       //primary keys
       this.languageSkillId__ = new LanguageSkillId();  	
       //attributes
       setMotherTongue (motherTongue);
       setRatingAverage (ratingAverage);
       setScriptAmount (scriptAmount);
       setIsSupervisor (isSupervisor);
       //parents
       if (setRelationship) this.iso6392t = new Language();
       if (setRelationship) this.iso6392t.setIso6392t(iso6392t); 
	   setIso6392t_ (iso6392t);
       if (setRelationship) this.userId = new User();
       if (setRelationship) this.userId.setUserId(userId); 
	   setUserId_ (userId);
    }

	public LanguageSkill flat() {
	   return new LanguageSkill(
		  getLanguageSkillId__().getUserId(),
		  getLanguageSkillId__().getIso6392t(),
          getMotherTongue(),
          getRatingAverage(),
          getScriptAmount(),
          getIsSupervisor()
       , false
	   );
	}


    public LanguageSkillId getLanguageSkillId__() {
		if (languageSkillId__==null) languageSkillId__ = new LanguageSkillId();
        return languageSkillId__;
    }
	
    public void setLanguageSkillId__ (LanguageSkillId languageSkillId__) {
        this.languageSkillId__ =  languageSkillId__;
    }
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-mother_tongue@
    public Boolean getMotherTongue() {
        return motherTongue;
    }
	
    public void setMotherTongue (Boolean motherTongue) {
        this.motherTongue =  motherTongue;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-rating_average@
    public Long getRatingAverage() {
        return ratingAverage;
    }
	
    public void setRatingAverage (Long ratingAverage) {
        this.ratingAverage =  ratingAverage;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-script_amount@
    public Integer getScriptAmount() {
        return scriptAmount;
    }
	
    public void setScriptAmount (Integer scriptAmount) {
        this.scriptAmount =  scriptAmount;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-is_supervisor@
    public Boolean getIsSupervisor() {
        return isSupervisor;
    }
	
    public void setIsSupervisor (Boolean isSupervisor) {
        this.isSupervisor =  isSupervisor;
    }
	
//MP-MANAGED-UPDATABLE-ENDING


    public Language getIso6392t () {
    	return iso6392t;
    }
	
    public void setIso6392t (Language iso6392t) {
    	this.iso6392t = iso6392t;
    }

    public String getIso6392t_() {
        return iso6392t_;
    }
	
    public void setIso6392t_ (String iso6392t) {
        this.iso6392t_ =  iso6392t;
    }
	
    public User getUserId () {
    	return userId;
    }
	
    public void setUserId (User userId) {
    	this.userId = userId;
    }

    public Integer getUserId_() {
        return userId_;
    }
	
    public void setUserId_ (Integer userId) {
        this.userId_ =  userId;
    }
	


//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @prepersist-language_skill@
    @javax.persistence.PrePersist
    public void prePersist_ () {
        if (ratingAverage==null) ratingAverage=__DEFAULT_RATING_AVERAGE;
        if (scriptAmount==null) scriptAmount=__DEFAULT_SCRIPT_AMOUNT;
    }
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @preupdate-language_skill@
    @javax.persistence.PreUpdate
    public void preUpdate_ () {
        if (ratingAverage==null) ratingAverage=__DEFAULT_RATING_AVERAGE;
        if (scriptAmount==null) scriptAmount=__DEFAULT_SCRIPT_AMOUNT;
    }
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @implementation@
//MP-MANAGED-ADDED-AREA-ENDING @implementation@

}
