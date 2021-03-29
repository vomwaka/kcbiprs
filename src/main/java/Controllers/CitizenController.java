package Controllers;

import Exceptions.ResourceNotFoundException;
import Models.Citizen;
import Repositories.CitizenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class CitizenController {

    @Autowired
    private CitizenRepo citizenRepo;

    //Add new citizen to IPRS Database
    @PostMapping("/newcitizen")
    public Citizen addCitizen(@RequestBody Citizen citizen){
        return citizenRepo.save(citizen);
    }

    //Get a citizen BY document type id
    @GetMapping("/getby/{id}")
    public ResponseEntity<Citizen> getCitizenByDocumentNumber (@PathVariable(value = "id") Long citizenDocId)
        throws ResourceNotFoundException {
        Citizen citizen = citizenRepo.findById(citizenDocId)
                .orElseThrow(()-> new ResourceNotFoundException("Citizen not found for document number :: " + citizenDocId));
        return ResponseEntity.ok().body(citizen);
    }

    //Gett All Citizens from CBS database
    @GetMapping("/subsidiaries")
    public List<Citizen> getAllCitizens() {
        return citizenRepo.findAll();
    }

    //Update citizen details
    @PutMapping("/citizens/{id}")
    public ResponseEntity<Citizen> updateCitizen(@PathVariable(value = "id") Long citizenId,
                                                 @RequestBody Citizen citizenDetails)
            throws ResourceNotFoundException {
        Citizen citizen = citizenRepo.findById(citizenId)
                .orElseThrow(() -> new ResourceNotFoundException("Citizen not found for this id :: " + citizenId));

        citizen.setFname(citizenDetails.getFname());
        citizen.setMname(citizenDetails.getMname());
        citizen.setLname(citizenDetails.getLname());
        citizen.setGender(citizenDetails.getGender());
        final Citizen updateCitizen = citizenRepo.save(citizen);
        return ResponseEntity.ok(updateCitizen);
    }

    //Delete a Citizen from ths CBS database
    @DeleteMapping("/citizen/{id}")
    public Map<String, Boolean> deleteCitizen(@PathVariable(value = "id") Long citizenId)
            throws ResourceNotFoundException {
        Citizen citizen = citizenRepo.findById(citizenId)
                .orElseThrow(() -> new ResourceNotFoundException("Citizen not found for this id :: " + citizenId));

        citizenRepo.delete(citizen);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
