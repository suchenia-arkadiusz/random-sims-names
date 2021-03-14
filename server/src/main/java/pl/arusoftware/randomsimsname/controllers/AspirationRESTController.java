package pl.arusoftware.randomsimsname.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pl.arusoftware.randomsimsname.controllers.data.request.AspirationRequest;
import pl.arusoftware.randomsimsname.controllers.data.response.AspirationResponse;
import pl.arusoftware.randomsimsname.data.entities.Aspiration;
import pl.arusoftware.randomsimsname.data.exceptions.AspirationNotFoundException;
import pl.arusoftware.randomsimsname.services.AspirationService;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/v1/aspirations", produces = MediaType.APPLICATION_JSON_VALUE)
public class AspirationRESTController {
    private final AspirationService aspirationService;

    public AspirationRESTController(AspirationService aspirationService) {
        this.aspirationService = aspirationService;
    }

    @PostMapping(value = {"/", ""})
    @ResponseBody
    public ResponseEntity<Object> addAspirations(@RequestBody List<AspirationRequest> request) {
        try {
            aspirationService.addAspirations(request
                    .stream()
                    .map(entry -> new Aspiration(entry.getName(), entry.getDescription(),
                            Aspiration.Category.valueOf(entry.getCategory().toUpperCase()), entry.getBonus(), entry.getDlcName(),
                            entry.getIsChild(), entry.getIsTeenager()))
                    .collect(Collectors.toList()));

            List<AspirationResponse> response = getAllAspirations();

            return ResponseEntity
                    .ok(response);
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error during add name");
        }
    }

    @GetMapping("/random")
    @ResponseBody
    public ResponseEntity<AspirationResponse> getRandomAspiration(@PathParam(value = "isChild") boolean isChild,
                                                @PathParam("isTeenager") boolean isTeenager) {
        Aspiration aspiration;

        if (isChild) {
            aspiration = aspirationService.getRandomAspirationForChild();
        } else if (isTeenager) {
            aspiration = aspirationService.getRandomAspirationForTeenager();
        } else {
            aspiration = aspirationService.getRandomAspiration();
        }
        AspirationResponse response = mapAspirationToResponse(aspiration);

        return ResponseEntity
                .ok(response);
    }

    @GetMapping(value = {"", "/"})
    @ResponseBody
    public ResponseEntity<List<AspirationResponse>> getAspirations() {
        List<AspirationResponse> response = getAllAspirations();

        return ResponseEntity
                .ok(response);
    }

    @DeleteMapping("/{name}")
    @ResponseBody
    public ResponseEntity<Object> deleteAspiration(@PathVariable String name) {
        try {
            aspirationService.deleteAspiration(name);

            List<AspirationResponse> response = getAllAspirations();

            return ResponseEntity
                    .ok(response);
        } catch (AspirationNotFoundException e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }
    }

    private AspirationResponse mapAspirationToResponse(Aspiration aspiration) {
        AspirationResponse response = new AspirationResponse();
        response.setName(aspiration.getId());
        response.setDescription(aspiration.getDescription());
        response.setCategory(aspiration.getCategory().toString());
        response.setBonus(aspiration.getBonus());
        response.setDlcName(aspiration.getDlcName());
        response.setIsChild(aspiration.isChild());
        response.setIsTeenager(aspiration.isTeenager());
        return response;
    }

    private List<AspirationResponse> getAllAspirations() {
        return aspirationService.getAllAspirations()
                .stream()
                .map(this::mapAspirationToResponse)
                .collect(Collectors.toList());
    }
}
