package fr.epsi.entity;

import lombok.Getter;
import lombok.Setter;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
@Getter @Setter


public class Auction {


    public class MaClasse {

        @ApiModelProperty(value = "Tag pour la méthode API")
        private String tag;

        @ApiModelProperty(value = "Sommaire pour la méthode API")
        private String sommaire;

        @ApiParam(name = "monParam", in = "query", description = "Description du paramètre", required = true, schema = @Schema(type = "string"))
        private String monParam;

        @ApiOperation(value = "Description de la méthode POST", notes = "Notes supplémentaires sur la méthode POST")
        @ApiResponses(value = {
                @ApiResponse(code = 200, message = "Success"),
                @ApiResponse(code = 400, message = "Bad Request"),
                @ApiResponse(code = 500, message = "Internal Server Error")
        })
        @POST
        @Path("/maMethode")
        @Consumes(MediaType.APPLICATION_JSON)
        @Produces(MediaType.APPLICATION_JSON)
        public Object maMethodePOST(
                @ApiParam(name = "monObjet", value = "Objet à envoyer dans la requête", required = true) Object monObjet) {
            // Traitement de la requête POST
            return new Object();
        }

        // Autres méthodes

    }

}
