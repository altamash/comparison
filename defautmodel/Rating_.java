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

import defaultroot.defautmodel.domain.defautmodel.Price;
import defaultroot.defautmodel.domain.defautmodel.Script;
import defaultroot.defautmodel.domain.defautmodel.Script;
import defaultroot.defautmodel.domain.defautmodel.Script;

@StaticMetamodel(Rating.class)
public class Rating_ {

    public static volatile SingularAttribute<Rating, Integer> ratingId;

    public static volatile SingularAttribute<Rating, Integer> rating;


    public static volatile SetAttribute<Rating, Price> priceRatingViaRatingId;
    public static volatile SetAttribute<Rating, Script> scriptRatingViaRatingIdRequest;
    public static volatile SetAttribute<Rating, Script> scriptRatingViaRatingIdScriptor;
    public static volatile SetAttribute<Rating, Script> scriptRatingViaRatingIdClient;


}
