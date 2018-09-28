package com.DizasterX;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.QueryParam;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;

import org.bson.Document;
import com.mongodb.Block;

import static com.mongodb.client.model.Filters.*;

import java.awt.SystemTray;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.ws.rs.core.Response;

/**
 * Root resource (exposed at "data" path)
 * 
 * The api provides:
 * @ Number : disasterNumber int
 * 
 * @ Date   : declaration    String
 *            fyDeclared     int
 *            begin          String
 *            end            String
 *            closeout       String
 *            lastrefresh    String
 * @ Place:   state          String
 *            county         String   not all
 *            palceCode      int      not all
 * 
 * @ Type   : incident       String
 *            disaster       String
 * 
 * @ Program: IH             int
 *            IA             int
 *            PA             int
 *            HM             int
 * 
 * @ Title                   String
 * @ Hash                    String
 * 
 */
@Path("data")
public class MyResource {
    @GET
    public String accessHome() {
        String res = "Hello, Welcome to DizasterX API";
        return res;
    }

    /**
     * Method handling declaration date
     * 
     * if params are null return all results
     * @param year Can be fuzzy
     * @param month Can be fuzzy
     * @param day Can be fuzzy
     * @return A list of entries match the declaration date
     */
    @GET
    @Path("/declarationDate")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByDeclarationDate(@QueryParam("year") String year, 
                                         @QueryParam("month") String month,
                                         @QueryParam("day") String day) {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase("DizasterX");
        MongoCollection<Document> collection = database.getCollection("data");

        final List<Document> entries = new ArrayList<>();

        Block<Document> addToList = new Block<Document>() {
            @Override
            public void apply(final Document document) {
                entries.add(document);
            }
        };

        // Regex 
        year = year == null ? ".*":year;
        month = month == null ? ".*":("-" + month + "-");
        day = day == null ? ".*":("-" + day + "T");

        Pattern yearPattern = Pattern.compile(year);
        Pattern monthPattern = Pattern.compile(month);
        Pattern dayPattern = Pattern.compile(day);

        collection.find(and(regex("declarationDate", yearPattern), 
                            regex("declarationDate", monthPattern),
                            regex("declarationDate", dayPattern))).forEach(addToList);
        
        // Packaging
        Document res = new Document("name", "Declartion Date")
                                   .append("size", entries.size())
                                   .append("entries", entries);

        mongoClient.close();
        return Response.ok() //200
                       .entity(res.toJson())
                       .header("Access-Control-Allow-Origin", "*")
                       .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
                       .allow("OPTIONS").build();
    }

    /**
     * Method handling fiscal year declared
     * 
     * @param year Must be accurate number for now
     * @return A list of entries match the fiscal year
     */
    @GET
    @Path("/fyDeclared")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByFyDeclared(@QueryParam("value") int value) {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase("DizasterX");
        MongoCollection<Document> collection = database.getCollection("data");
        
        final List<Document> entries = new ArrayList<>();

        Block<Document> addToList = new Block<Document>() {
            @Override
            public void apply(final Document document) {
                entries.add(document);
            }
        };

        // Find exact year
        collection.find(eq("fyDeclared", value)).forEach(addToList);
        
        // Packaging
        Document res = new Document("name", "Fiscal Year Declared")
                                   .append("size", entries.size())
                                   .append("entries", entries);

        mongoClient.close();
        return Response.ok() //200
                       .entity(res.toJson())
                       .header("Access-Control-Allow-Origin", "*")
                       .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
                       .allow("OPTIONS").build();
    }

    /**
     * Method handling begin date
     * 
     * if params are null return all results
     * @param year Can be fuzzy
     * @param month Can be fuzzy
     * @param day Can be fuzzy
     * @return A list of entries match the begin date
     */
    @GET
    @Path("/incidentBeginDate")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByIncidentBeginDate(@QueryParam("year") String year, 
                                           @QueryParam("month") String month,
                                           @QueryParam("day") String day) {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase("DizasterX");
        MongoCollection<Document> collection = database.getCollection("data");

        final List<Document> entries = new ArrayList<>();

        Block<Document> addToList = new Block<Document>() {
            @Override
            public void apply(final Document document) {
                entries.add(document);
            }
        };

        // Regex 
        year = year == null ? ".*":year;
        month = month == null ? ".*":("-" + month + "-");
        day = day == null ? ".*":("-" + day + "T");

        Pattern yearPattern = Pattern.compile(year);
        Pattern monthPattern = Pattern.compile(month);
        Pattern dayPattern = Pattern.compile(day);

        collection.find(and(regex("incidentBeginDate", yearPattern), 
                            regex("incidentBeginDate", monthPattern),
                            regex("incidentBeginDate", dayPattern))).forEach(addToList);
        
        // Packaging
        Document res = new Document("name", "Incident Begin Date")
                                   .append("size", entries.size())
                                   .append("entries", entries);

        mongoClient.close();
        return Response.ok() //200
                       .entity(res.toJson())
                       .header("Access-Control-Allow-Origin", "*")
                       .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
                       .allow("OPTIONS").build();
    }

    /**
     * Method handling end date
     * 
     * if params are null return all results
     * @param year Can be fuzzy
     * @param month Can be fuzzy
     * @param day Can be fuzzy
     * @return A list of entries match the end date
     */
    @GET
    @Path("/incidentEndDate")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByIncidentEndDate(@QueryParam("year") String year, 
                                         @QueryParam("month") String month,
                                         @QueryParam("day") String day) {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase("DizasterX");
        MongoCollection<Document> collection = database.getCollection("data");

        final List<Document> entries = new ArrayList<>();

        Block<Document> addToList = new Block<Document>() {
            @Override
            public void apply(final Document document) {
                entries.add(document);
            }
        };

        // Regex 
        year = year == null ? ".*":year;
        month = month == null ? ".*":("-" + month + "-");
        day = day == null ? ".*":("-" + day + "T");

        Pattern yearPattern = Pattern.compile(year);
        Pattern monthPattern = Pattern.compile(month);
        Pattern dayPattern = Pattern.compile(day);

        collection.find(and(regex("incidentEndDate", yearPattern), 
                            regex("incidentEndDate", monthPattern),
                            regex("incidentEndDate", dayPattern))).forEach(addToList);
        
        // Packaging
        Document res = new Document("name", "Incident End Date")
                                   .append("size", entries.size())
                                   .append("entries", entries);

        mongoClient.close();
        return Response.ok() //200
                       .entity(res.toJson())
                       .header("Access-Control-Allow-Origin", "*")
                       .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
                       .allow("OPTIONS").build();
    }

    /**
     * Method handling close out date
     * 
     * if params are null return all results
     * @param year Can be fuzzy
     * @param month Can be fuzzy
     * @param day Can be fuzzy
     * @return A list of entries match the close out date
     */
    @GET
    @Path("/disasterCloseOutDate")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByDisasterCloseOutDate(@QueryParam("year") String year, 
                                              @QueryParam("month") String month,
                                              @QueryParam("day") String day) {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase("DizasterX");
        MongoCollection<Document> collection = database.getCollection("data");

        final List<Document> entries = new ArrayList<>();

        Block<Document> addToList = new Block<Document>() {
            @Override
            public void apply(final Document document) {
                entries.add(document);
            }
        };

        // Regex 
        year = year == null ? ".*":year;
        month = month == null ? ".*":("-" + month + "-");
        day = day == null ? ".*":("-" + day + "T");

        Pattern yearPattern = Pattern.compile(year);
        Pattern monthPattern = Pattern.compile(month);
        Pattern dayPattern = Pattern.compile(day);

        collection.find(and(regex("disasterCloseOutDate", yearPattern), 
                            regex("disasterCloseOutDate", monthPattern),
                            regex("disasterCloseOutDate", dayPattern))).forEach(addToList);
        
        // Packaging
        Document res = new Document("name", "Incident End Date")
                                   .append("size", entries.size())
                                   .append("entries", entries);

        mongoClient.close();
        return Response.ok() //200
                       .entity(res.toJson())
                       .header("Access-Control-Allow-Origin", "*")
                       .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
                       .allow("OPTIONS").build();
    }

    /**
     * Method handling last refresh date
     * 
     * if params are null return all results
     * @param year Can be fuzzy
     * @param month Can be fuzzy
     * @param day Can be fuzzy
     * @return A list of entries match last refresh date
     */
    @GET
    @Path("/lastRefresh")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByLastRefresh(@QueryParam("year") String year, 
                                     @QueryParam("month") String month,
                                     @QueryParam("day") String day) {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase("DizasterX");
        MongoCollection<Document> collection = database.getCollection("data");

        final List<Document> entries = new ArrayList<>();

        Block<Document> addToList = new Block<Document>() {
            @Override
            public void apply(final Document document) {
                entries.add(document);
            }
        };

        // Regex 
        year = year == null ? ".*":year;
        month = month == null ? ".*":("-" + month + "-");
        day = day == null ? ".*":("-" + day + "T");

        Pattern yearPattern = Pattern.compile(year);
        Pattern monthPattern = Pattern.compile(month);
        Pattern dayPattern = Pattern.compile(day);

        collection.find(and(regex("lastRefresh", yearPattern), 
                            regex("lastRefresh", monthPattern),
                            regex("lastRefresh", dayPattern))).forEach(addToList);
        
        // Packaging
        Document res = new Document("name", "Last Update")
                                   .append("size", entries.size())
                                   .append("entries", entries);

        mongoClient.close();
        return Response.ok() //200
                       .entity(res.toJson())
                       .header("Access-Control-Allow-Origin", "*")
                       .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
                       .allow("OPTIONS").build();
    }

    /**
     * Method handling state
     * 
     * if params are null return all results
     * @param state state abbreviation
     * @return A list of entries match the state
     */
    @GET
    @Path("/state")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByState(@QueryParam("value") String value) {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase("DizasterX");
        MongoCollection<Document> collection = database.getCollection("data");

        final List<Document> entries = new ArrayList<>();

        Block<Document> addToList = new Block<Document>() {
            @Override
            public void apply(final Document document) {
                entries.add(document);
            }
        };

        Pattern pattern = Pattern.compile(value, Pattern.CASE_INSENSITIVE);
        collection.find(regex("state", pattern)).forEach(addToList);
        
        // Packaging
        Document res = new Document("name", "State")
                                   .append("size", entries.size())
                                   .append("entries", entries);

        mongoClient.close();
        // return res.toJson();
        return Response.ok() //200
                       .entity(res.toJson())
                       .header("Access-Control-Allow-Origin", "*")
                       .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
                       .allow("OPTIONS").build();
    }

    /**
     * Method handling county
     * 
     * if params are null return all results
     * @param state state abbreviation
     * @return A list of entries match county name
     */
    @GET
    @Path("/county")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByCounty(@QueryParam("value") String value) {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase("DizasterX");
        MongoCollection<Document> collection = database.getCollection("data");

        final List<Document> entries = new ArrayList<>();

        Block<Document> addToList = new Block<Document>() {
            @Override
            public void apply(final Document document) {
                entries.add(document);
            }
        };

        Pattern pattern = Pattern.compile(value, Pattern.CASE_INSENSITIVE);
        collection.find(regex("state", pattern)).forEach(addToList);
        
        // Packaging
        Document res = new Document("name", "County")
                                   .append("size", entries.size())
                                   .append("entries", entries);

        mongoClient.close();
        return Response.ok() //200
                       .entity(res.toJson())
                       .header("Access-Control-Allow-Origin", "*")
                       .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
                       .allow("OPTIONS").build();
    }

    /**
     * Method handling place code
     * 
     * @param year Must be accurate number for now
     * @return A list of entries match the place code
     */
    @GET
    @Path("/placeCode")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByPlaceCode(@QueryParam("value") int value) {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase("DizasterX");
        MongoCollection<Document> collection = database.getCollection("data");
        
        final List<Document> entries = new ArrayList<>();

        Block<Document> addToList = new Block<Document>() {
            @Override
            public void apply(final Document document) {
                entries.add(document);
            }
        };

        // Find exact plcae code
        collection.find(eq("placeCode", value)).forEach(addToList);
        
        // Packaging
        Document res = new Document("name", "Place Code")
                                   .append("size", entries.size())
                                   .append("entries", entries);

        mongoClient.close();
        return Response.ok() //200
                       .entity(res.toJson())
                       .header("Access-Control-Allow-Origin", "*")
                       .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
                       .allow("OPTIONS").build();
    }

    /**
     * Method handling ihProgramDeclared
     * 
     * @param year Must be accurate number for now
     * @return A list of entries match the ihProgramDeclared
     */
    @GET
    @Path("/ihProgramDeclared")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByIHProgram(@QueryParam("value") int value) {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase("DizasterX");
        MongoCollection<Document> collection = database.getCollection("data");
        
        final List<Document> entries = new ArrayList<>();

        Block<Document> addToList = new Block<Document>() {
            @Override
            public void apply(final Document document) {
                entries.add(document);
            }
        };

        // find exact ih program value
        collection.find(eq("ihProgramDeclared", value)).forEach(addToList);
        
        // Packaging
        Document res = new Document("name", "IH Program")
                                   .append("entries", entries);

        mongoClient.close();
        return Response.ok() //200
                       .entity(res.toJson())
                       .header("Access-Control-Allow-Origin", "*")
                       .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
                       .allow("OPTIONS").build();
    }

    /**
     * Method handling iaProgramDeclared
     * 
     * @param year Must be accurate number for now
     * @return A list of entries match the iaProgramDeclared
     */
    @GET
    @Path("/iaProgramDeclared")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByIAProgram(@QueryParam("value") int value) {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase("DizasterX");
        MongoCollection<Document> collection = database.getCollection("data");
        
        final List<Document> entries = new ArrayList<>();

        Block<Document> addToList = new Block<Document>() {
            @Override
            public void apply(final Document document) {
                entries.add(document);
            }
        };

        // find exact ia program value
        collection.find(eq("iaProgramDeclared", value)).forEach(addToList);
        
        // Packaging
        Document res = new Document("name", "IA Program")
                                   .append("entries", entries);

        mongoClient.close();
        return Response.ok() //200
                       .entity(res.toJson())
                       .header("Access-Control-Allow-Origin", "*")
                       .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
                       .allow("OPTIONS").build();
    }

    /**
     * Method handling paProgramDeclared
     * 
     * @param year Must be accurate number for now
     * @return A list of entries match the paProgramDeclared
     */
    @GET
    @Path("/paProgramDeclared")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByPAProgram(@QueryParam("value") int value) {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase("DizasterX");
        MongoCollection<Document> collection = database.getCollection("data");
        
        final List<Document> entries = new ArrayList<>();

        Block<Document> addToList = new Block<Document>() {
            @Override
            public void apply(final Document document) {
                entries.add(document);
            }
        };

        // find exact PA program value
        collection.find(eq("paProgramDeclared", value)).forEach(addToList);
        
        // Packaging
        Document res = new Document("name", "PA Program")
                                   .append("entries", entries);

        mongoClient.close();
        return Response.ok() //200
                       .entity(res.toJson())
                       .header("Access-Control-Allow-Origin", "*")
                       .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
                       .allow("OPTIONS").build();
    }

    /**
     * Method handling hmProgramDeclared
     * 
     * @param year Must be accurate number for now
     * @return A list of entries match the hmProgramDeclared
     */
    @GET
    @Path("/hmProgramDeclared")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByHMProgram(@QueryParam("value") int value) {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase("DizasterX");
        MongoCollection<Document> collection = database.getCollection("data");
        
        final List<Document> entries = new ArrayList<>();

        Block<Document> addToList = new Block<Document>() {
            @Override
            public void apply(final Document document) {
                entries.add(document);
            }
        };

        // find exact hm program value
        collection.find(eq("hmProgramDeclared", value)).forEach(addToList);
        
        // Packaging
        Document res = new Document("name", "HM Program")
                                   .append("size", entries.size())
                                   .append("entries", entries);

        mongoClient.close();
        return Response.ok() //200
                       .entity(res.toJson())
                       .header("Access-Control-Allow-Origin", "*")
                       .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
                       .allow("OPTIONS").build();
    }

    /**
     * Method handling disaster title
     * 
     * @param Title support fuzzy matching and case insensitive. 
     *        i.e. "tornado"/"tor" will return all contain
     *        "TORNADO"
     * @return A list of entries match the title name.
     */
    @GET
    @Path("/title")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByTitle(@QueryParam("value") String value) {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase("DizasterX");
        MongoCollection<Document> collection = database.getCollection("data");
        
        final List<Document> entries = new ArrayList<>();

        Block<Document> addToList = new Block<Document>() {
            @Override
            public void apply(final Document document) {
                entries.add(document);
            }
        };

        Pattern pattern = Pattern.compile(value, Pattern.CASE_INSENSITIVE);
        collection.find(regex("title", pattern)).forEach(addToList);
        
        // Packaging
        Document res = new Document("name", "Title")
                                   .append("size", entries.size())
                                   .append("entries", entries);

        mongoClient.close();
        return Response.ok() //200
                       .entity(res.toJson())
                       .header("Access-Control-Allow-Origin", "*")
                       .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
                       .allow("OPTIONS").build();
    }

    /**
     * Method handling disaster hash
     * 
     * @param Hash
     * @return One entry match the hash value
     */
    @GET
    @Path("/hash")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByHash(@QueryParam("value") String value) {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase("DizasterX");
        MongoCollection<Document> collection = database.getCollection("data");

        Document entries = collection.find(eq("hash", value)).first();

        // Packaging
        Document res = new Document("name", "Hash")
                                   .append("size", entries.size())
                                   .append("entries", entries);
        
        mongoClient.close();
        return Response.ok() //200
                       .entity(res.toJson())
                       .header("Access-Control-Allow-Origin", "*")
                       .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
                       .allow("OPTIONS").build();
    }

    /**
     * Method handling list request
     * 
     * First query MongoDB by dates.
     * Then use regex to match the search words
     * 
     * @param date1 start date 00000000 for the blank
     * @param date2 end date 99999999 for the blank
     * @param states support multiple
     * @param incidentTypes support multiple
     * 
     * @return the values in [date1, date2] which match states and incidentTypes
     */
    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response list(@QueryParam("date1") String date1,
                         @QueryParam("date2") String date2,
                         @QueryParam("states") String states, 
                         @QueryParam("incidentTypes") String incidentTypes) {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase("DizasterX");
        // We use new date base here.
        MongoCollection<Document> collection = database.getCollection("data1");

        final List<Document> tempEntries = new ArrayList<>();
        final List<Document> entries = new ArrayList<>();
        
        Block<Document> addToList = new Block<Document>() {
            @Override
            public void apply(final Document document) {
                tempEntries.add(document);
            }
        };
        
        // First filter by dates
        date1 = (date1 == null)? "00000000": date1;
        date2 = (date2 == null)? "99999999": date2;
        collection.find(and(gte("dateNumber", Integer.parseInt(date1)),
                            lte("dateNumber", Integer.parseInt(date2)))).forEach(addToList);

        // Regex match the state and incidentType
        for(Document entry : tempEntries) {
            String statePattern;
            String typePattern;
            boolean bState, bType;

            statePattern = ".*(?i)" + entry.get("state") + "(?-i).*";
            bState = (states == null) ? true:Pattern.matches(statePattern, states);
            typePattern = ".*(?i)" + entry.get("incidentType") + "(?-i).*";
            bType = (incidentTypes == null) ? true:Pattern.matches(typePattern, incidentTypes);
            if (bState && bType) {
                entries.add(entry);
            }
        }

        // Packaging
        Document res = new Document("name", "list")
                                   .append("size", entries.size())
                                   .append("entries", entries);
        
        mongoClient.close();
        return Response.ok() //200
                       .entity(res.toJson())
                       .header("Access-Control-Allow-Origin", "*")
                       .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
                       .allow("OPTIONS").build();
    }
}
