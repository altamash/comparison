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
import defaultroot.defautmodel.domain.defautmodel.LanguageTranslateId;

/**
 *
 * <p>Title: LanguageTranslate</p>
 *
 * <p>Description: Domain Object describing a LanguageTranslate entity</p>
 *
 */
@Entity (name="LanguageTranslate")
@Table (name="\"language_translate\"")
@NamedQueries ({
	 @NamedQuery(name="LanguageTranslate.findAll", query="SELECT languagetranslate FROM LanguageTranslate languagetranslate")
	,@NamedQuery(name="LanguageTranslate.findByLanguageName", query="SELECT languagetranslate FROM LanguageTranslate languagetranslate WHERE languagetranslate.languageName = :languageName")
	,@NamedQuery(name="LanguageTranslate.findByLanguageNameContaining", query="SELECT languagetranslate FROM LanguageTranslate languagetranslate WHERE languagetranslate.languageName like :languageName")

})

public class LanguageTranslate implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String FIND_ALL = "LanguageTranslate.findAll";
    public static final String FIND_BY_LANGUAGENAME = "LanguageTranslate.findByLanguageName";
    public static final String FIND_BY_LANGUAGENAME_CONTAINING ="LanguageTranslate.findByLanguageNameContaining";
	
    @EmbeddedId
    private LanguageTranslateId languageTranslateId__;
    @Column(name="for_iso6392t" , length=3 , nullable=false , unique=false , insertable=false, updatable=false)
    private String forIso6392t_;
//MP-MANAGED-ADDED-AREA-BEGINNING @language_name-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @language_name-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-language_name@
    @Column(name="language_name"  , length=100 , nullable=false , unique=false)
    private String languageName; 
//MP-MANAGED-UPDATABLE-ENDING

    @MapsId ("iso6392t")
    @ManyToOne (fetch=FetchType.LAZY , optional=false)
    @JoinColumn(name="iso6392t", referencedColumnName = "iso6392t" , nullable=false , unique=false , insertable=true, updatable=true) 
    private Language iso6392t;  

    @Column(name="iso6392t" , length=3 , nullable=false , unique=true, insertable=false, updatable=false)
    private String iso6392t_;

    /**
    * Default constructor
    */
    public LanguageTranslate() {
    }

	/**
	* All field constructor 
	*/
    public LanguageTranslate(
       String iso6392t,
       String languageName,
       String forIso6392t) {
	 this(
       iso6392t,
       languageName,
       forIso6392t
	 ,true);
	}
    
	public LanguageTranslate(
       String iso6392t,
       String languageName,
       String forIso6392t	
    , boolean setRelationship) {
       //primary keys
       this.languageTranslateId__ = new LanguageTranslateId();  	
       this.languageTranslateId__.setForIso6392t (forIso6392t);
       //attributes
       setLanguageName (languageName);
       //parents
       if (setRelationship) this.iso6392t = new Language();
       if (setRelationship) this.iso6392t.setIso6392t(iso6392t); 
	   setIso6392t_ (iso6392t);
    }

	public LanguageTranslate flat() {
	   return new LanguageTranslate(
		  getLanguageTranslateId__().getIso6392t(),
          getLanguageName(),
		  getLanguageTranslateId__().getForIso6392t()
       , false
	   );
	}


    public LanguageTranslateId getLanguageTranslateId__() {
		if (languageTranslateId__==null) languageTranslateId__ = new LanguageTranslateId();
        return languageTranslateId__;
    }
	
    public void setLanguageTranslateId__ (LanguageTranslateId languageTranslateId__) {
        this.languageTranslateId__ =  languageTranslateId__;
    }
    public String getForIso6392t_() {
        return forIso6392t_;
    }
	
    public void setForIso6392t_ (String forIso6392t) {
        this.forIso6392t_ =  forIso6392t_;
    }
    
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-language_name@
    public String getLanguageName() {
        return languageName;
    }
	
    public void setLanguageName (String languageName) {
        this.languageName =  languageName;
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
	




//MP-MANAGED-ADDED-AREA-BEGINNING @implementation@
//MP-MANAGED-ADDED-AREA-ENDING @implementation@

}
