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
	* - name      : DomainEntityJPA2Metamodel
	* - file name : DomainEntityJPA2Metamodel.vm
	* - time      : 2015/08/04 AD at 17:45:44 PKT
*/
package defaultroot.defautmodel.domain.defautmodel;

import java.sql.*;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import javax.persistence.metamodel.SetAttribute;

import defaultroot.defautmodel.domain.defautmodel.Script;
import defaultroot.defautmodel.domain.defautmodel.Language;
import defaultroot.defautmodel.domain.defautmodel.Translation;
import defaultroot.defautmodel.domain.defautmodel.Rating;
import defaultroot.defautmodel.domain.defautmodel.ScriptType;

@StaticMetamodel(Price.class)
public class Price_ {

    public static volatile SingularAttribute<Price, Integer> priceId;

    public static volatile SingularAttribute<Price, String> currency;
    public static volatile SingularAttribute<Price, Long> price;
    public static volatile SingularAttribute<Price, Long> cost;


    public static volatile SingularAttribute<Price, Language> iso6392t;
    public static volatile SingularAttribute<Price, String> iso6392t_;

    public static volatile SingularAttribute<Price, Translation> translationId;
    public static volatile SingularAttribute<Price, Integer> translationId_;

    public static volatile SingularAttribute<Price, Rating> ratingId;
    public static volatile SingularAttribute<Price, Integer> ratingId_;

    public static volatile SingularAttribute<Price, ScriptType> scriptTypeId;
    public static volatile SingularAttribute<Price, Integer> scriptTypeId_;

    public static volatile SetAttribute<Price, Script> scriptPriceViaPriceId;


}
