/*
 * Copyright 2016 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
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
 */

package myapp;

import java.io.IOException;
import java.util.Random;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

class Location{
    public Double lat;
    public Double lon;
    public String name;
    public Integer price;
    public Integer rating;
    Location(Double lat,Double lon,String name,Integer price,Integer rating){
        this.lat=lat;
        this.lon=lon;
        this.price=price;
        this.name=name;
        this.rating=rating;
    }
    Location(){

    }
    @java.lang.Override
    public java.lang.String toString() {
        return "{" +
                "\"lat\":" + lat +
                ",\"lng\":" + -lon +
                ",\"name\":\"" + name +"\""+
                ",\"price\":" + price +
                ",\"rating\":" + rating +
                '}';
    }
}
public class LocationServlet extends HttpServlet {

    public static String[] Adj=new String[]{"Cool","Great","Amazing","Perfect","Small","Scenic","Wonderful","Ocean","Tiny","Big"};

    public Location[] GenerateLocations(){
        Location[] locations=new Location[10];
        Random chaos=new Random();
        for(int i=0;i<locations.length;i++){

            Location location=new Location();
            location.lat=36.6002+chaos.nextDouble()*0.01;
            location.lon=121.8947+chaos.nextDouble()*0.01;
            location.price=(1+chaos.nextInt(10))*100;
            location.rating=1+chaos.nextInt(5);
            location.name=String.format("%s Spot",Adj[chaos.nextInt(Adj.length)]);
            locations[i]=location;

        }
        return locations;
    }
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        String json="[";
        Location[] locations=GenerateLocations();
        for(int i=0;i<locations.length-1;i++){
            json+=locations[i].toString()+",";
        }
        json+=locations[locations.length-1].toString()+"]";
        resp.setContentType("text/plain");
        resp.getWriter().println(json);
    }
}
