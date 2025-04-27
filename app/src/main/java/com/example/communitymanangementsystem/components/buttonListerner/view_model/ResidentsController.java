package com.example.communitymanangementsystem.components.buttonListerner.view_model;

import com.example.communitymanangementsystem.R;
import com.example.communitymanangementsystem.model.ResidentsViewModel;

import java.util.List;

public class ResidentsController {

    private List<ResidentsViewModel> data;

    public ResidentsController(List<ResidentsViewModel> data) {
        this.data = data;
        this.data.add(new ResidentsViewModel(
                1, "Juan", "Dela", "Cruz", "Male", "1990-01-01", "juan.delacruz@example.com",
                "Filipino", "Catholic", "21", "09123456789", "College", "Single", "70kg",
                "Urban Poor", "Concrete", "170cm", "2000", "Sitio Uno", "Owned", "Purok 1",
                "Concrete", "Yes", "Permanent", "Active", "2025-01-01", R.drawable.robin
        ));
        this.data.add(new ResidentsViewModel(
                2, "Rodrigo", "Roa", "Duterte", "Male", "1990-01-01", "juan.delacruz@example.com",
                "Filipino", "Catholic", "21", "09123456789", "College", "Single", "70kg",
                "Urban Poor", "Concrete", "170cm", "2000", "Sitio Uno", "Owned", "Purok 1",
                "Concrete", "Yes", "Permanent", "Active", "2025-01-01", R.drawable.duterte
        ));
        this.data.add(new ResidentsViewModel(
                3, "Juan", "Apale", "Bayot-Lang", "Male", "1990-01-01", "juan.delacruz@example.com",
                "Filipino", "Catholic", "21", "09123456789", "College", "Single", "70kg",
                "Urban Poor", "Concrete", "170cm", "2000", "Sitio Uno", "Owned", "Purok 1",
                "Concrete", "Yes", "Permanent", "Active", "2025-01-01", R.drawable.pacman
        ));
        this.data.add(new ResidentsViewModel(
                4, "Daniel", "Robin", "Padaplin", "Male", "1990-01-01", "juan.delacruz@example.com",
                "Filipino", "Catholic", "21", "09123456789", "College", "Single", "70kg",
                "Urban Poor", "Concrete", "170cm", "2000", "Sitio Uno", "Owned", "Purok 1",
                "Concrete", "Yes", "Permanent", "Active", "2025-01-01", R.drawable.daniel
        ));
        this.data.add(new ResidentsViewModel(
                5, "Daniel", "Robin", "Padaplin", "Male", "1990-01-01", "juan.delacruz@example.com",
                "Filipino", "Catholic", "21", "09123456789", "College", "Single", "70kg",
                "Urban Poor", "Concrete", "170cm", "2000", "Sitio Uno", "Owned", "Purok 1",
                "Concrete", "Yes", "Permanent", "Active", "2025-01-01", R.drawable.daniel
        ));
    }

    public List<ResidentsViewModel> getResidents() {
        return data;
    }
}
