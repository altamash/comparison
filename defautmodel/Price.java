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
import defaultroot.defautmodel.domain.defautmodel.Script;
import defaultroot.defautmodel.domain.defautmodel.Language;
import defaultroot.defautmodel.domain.defautmodel.Translation;
import defaultroot.defautmodel.domain.defautmodel.Rating;
import defaultroot.defautmodel.domain.defautmodel.ScriptType;

/**
 *
 * <p>Title: Price</p>
 *
 * <p>Description: Domain Object describing a Price entity</p>
 *
 */
@Entity (name="Price")
@Table (name="\"price\"")
@NamedQueries ({
	 @NamedQuery(name="Price.findAll", query="SELECT price FROM Price price")
	,@NamedQuery(name="Price.findByCurrency", query="SELECT price FROM Price price WHERE price.currency = :currency")
	,@NamedQuery(name="Price.findByCurrencyContaining", query="SELECT price FROM Price price WHERE price.currency like :currency")

	,@NamedQuery(name="Price.findByPrice", query="SELECT price FROM Price price WHERE price.price = :price")

	,@NamedQuery(name="Price.findByCost", query="SELECT price FROM Price price WHERE price.cost = :cost")

})

public class Price implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String FIND_ALL = "Price.findAll";
    public static final String FIND_BY_CURRENCY = "Price.findByCurrency";
    public static final String FIND_BY_CURRENCY_CONTAINING ="Price.findByCurrencyContaining";
    public static final String FIND_BY_PRICE = "Price.findByPrice";
    public static final String FIND_BY_COST = "Price.findByCost";
	
    @Id @Column(name="price_id" ) 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer priceId;

//MP-MANAGED-ADDED-AREA-BEGINNING @currency-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @currency-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-currency@
    @Column(name="currency"  , length=3 , nullable=false , unique=false)
    private String currency; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @price-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @price-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-price@
    @Column(name="price"   , nullable=false , unique=false)
    private Long price; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @cost-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @cost-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-cost@
    @Column(name="cost"   , nullable=false , unique=false)
    private Long cost; 
//MP-MANAGED-UPDATABLE-ENDING

    @ManyToOne (fetch=FetchType.LAZY )
    @JoinColumn(name="iso6392t", referencedColumnName = "iso6392t" , nullable=true , unique=false , insertable=true, updatable=true) 
    private Language iso6392t;  

    @Column(name="iso6392t" , length=3 , nullable=true , unique=true, insertable=false, updatable=false)
    private String iso6392t_;

    @ManyToOne (fetch=FetchType.LAZY )
    @JoinColumn(name="translation_id", referencedColumnName = "translation_id" , nullable=true , unique=true  , insertable=true, updatable=true) 
    private Translation translationId;  

    @Column(name="translation_id"  , nullable=true , unique=true, insertable=false, updatable=false)
    private Integer translationId_;

    @ManyToOne (fetch=FetchType.LAZY , optional=false)
    @JoinColumn(name="rating_id", referencedColumnName = "rating_id" , nullable=false , unique=true  , insertable=true, updatable=true) 
    private Rating ratingId;  

    @Column(name="rating_id"  , nullable=false , unique=true, insertable=false, updatable=false)
    private Integer ratingId_;

    @ManyToOne (fetch=FetchType.LAZY , optional=false)
    @JoinColumn(name="script_type_id", referencedColumnName = "script_type_id" , nullable=false , unique=true  , insertable=true, updatable=true) 
    private ScriptType scriptTypeId;  

    @Column(name="script_type_id"  , nullable=false , unique=true, insertable=false, updatable=false)
    private Integer scriptTypeId_;

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @scriptPriceViaPriceId-field-price@
    @OneToMany (targetEntity=defaultroot.defautmodel.domain.defautmodel.Script.class, fetch=FetchType.LAZY, mappedBy="priceId", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <Script> scriptPriceViaPriceId = new HashSet<Script>(); 

//MP-MANAGED-UPDATABLE-ENDING
    /**
    * Default constructor
    */
    public Price() {
    }

	/**
	* All field constructor 
	*/
    public Price(
       Integer priceId,
       String currency,
       Long price,
       Long cost,
       String iso6392t,
       Integer translationId,
       Integer ratingId,
       Integer scriptTypeId) {
	 this(
       priceId,
       currency,
       price,
       cost,
       iso6392t,
       translationId,
       ratingId,
       scriptTypeId
	 ,true);
	}
    
	public Price(
       Integer priceId,
       String currency,
       Long price,
       Long cost,
       String iso6392t,
       Integer translationId,
       Integer ratingId,
       Integer scriptTypeId	
    , boolean setRelationship) {
       //primary keys
       setPriceId (priceId);
       //attributes
       setCurrency (currency);
       setPrice (price);
       setCost (cost);
       //parents
       if (setRelationship) this.iso6392t = new Language();
       if (setRelationship) this.iso6392t.setIso6392t(iso6392t); 
	   setIso6392t_ (iso6392t);
       if (setRelationship) this.translationId = new Translation();
       if (setRelationship) this.translationId.setTranslationId(translationId); 
	   setTranslationId_ (translationId);
       if (setRelationship) this.ratingId = new Rating();
       if (setRelationship) this.ratingId.setRatingId(ratingId); 
	   setRatingId_ (ratingId);
       if (setRelationship) this.scriptTypeId = new ScriptType();
       if (setRelationship) this.scriptTypeId.setScriptTypeId(scriptTypeId); 
	   setScriptTypeId_ (scriptTypeId);
    }

	public Price flat() {
	   return new Price(
          getPriceId(),
          getCurrency(),
          getPrice(),
          getCost(),
          getIso6392t_(),
          getTranslationId_(),
          getRatingId_(),
          getScriptTypeId_()
       , false
	   );
	}

    public Integer getPriceId() {
        return priceId;
    }
	
    public void setPriceId (Integer priceId) {
        this.priceId =  priceId;
    }
    
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-currency@
    public String getCurrency() {
        return currency;
    }
	
    public void setCurrency (String currency) {
        this.currency =  currency;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-price@
    public Long getPrice() {
        return price;
    }
	
    public void setPrice (Long price) {
        this.price =  price;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-cost@
    public Long getCost() {
        return cost;
    }
	
    public void setCost (Long cost) {
        this.cost =  cost;
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
	
    public Translation getTranslationId () {
    	return translationId;
    }
	
    public void setTranslationId (Translation translationId) {
    	this.translationId = translationId;
    }

    public Integer getTranslationId_() {
        return translationId_;
    }
	
    public void setTranslationId_ (Integer translationId) {
        this.translationId_ =  translationId;
    }
	
    public Rating getRatingId () {
    	return ratingId;
    }
	
    public void setRatingId (Rating ratingId) {
    	this.ratingId = ratingId;
    }

    public Integer getRatingId_() {
        return ratingId_;
    }
	
    public void setRatingId_ (Integer ratingId) {
        this.ratingId_ =  ratingId;
    }
	
    public ScriptType getScriptTypeId () {
    	return scriptTypeId;
    }
	
    public void setScriptTypeId (ScriptType scriptTypeId) {
    	this.scriptTypeId = scriptTypeId;
    }

    public Integer getScriptTypeId_() {
        return scriptTypeId_;
    }
	
    public void setScriptTypeId_ (Integer scriptTypeId) {
        this.scriptTypeId_ =  scriptTypeId;
    }
	

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @scriptPriceViaPriceId-getter-price@
    public Set<Script> getScriptPriceViaPriceId() {
        if (scriptPriceViaPriceId == null){
            scriptPriceViaPriceId = new HashSet<Script>();
        }
        return scriptPriceViaPriceId;
    }

    public void setScriptPriceViaPriceId (Set<Script> scriptPriceViaPriceId) {
        this.scriptPriceViaPriceId = scriptPriceViaPriceId;
    }	
    
    public void addScriptPriceViaPriceId (Script element) {
    	    getScriptPriceViaPriceId().add(element);
    }
    
//MP-MANAGED-UPDATABLE-ENDING



//MP-MANAGED-ADDED-AREA-BEGINNING @implementation@
//MP-MANAGED-ADDED-AREA-ENDING @implementation@

}
