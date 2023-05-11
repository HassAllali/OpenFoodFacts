package service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import com.openfoodfact.model.Additif;
import com.openfoodfact.model.Allergene;
import com.openfoodfact.model.Categorie;
import com.openfoodfact.model.Ingredient;
import com.openfoodfact.model.Marque;
import com.openfoodfact.model.Nutri;
import com.openfoodfact.model.Produit;

import dao.DAOAdditif;
import dao.DAOAllergene;
import dao.DAOCategorie;
import dao.DAOFactory;
import dao.DAOIngredient;
import dao.DAOMarque;

public class Lire {

	public void parseFile() throws IOException {

		Path pathFile = Paths.get("open-food-facts.csv");
		List<String> lines = Files.readAllLines(pathFile, StandardCharsets.UTF_8);

		int count= 0;
		
		long debut = System.currentTimeMillis();
		
		for(String line : lines) {
			if(count == 0) {
				count++;
				continue;
			}
			Produit produit = new Produit();
			String[] values = line.split("\\|") ;		
            for (int i = 0; i< values.length; i++) {
            	if(values[i].trim().length() == 0 ) {
            		continue;
            	}
            	switch (i) {
            
				case 0: 
					DAOCategorie DAOcategorie = DAOFactory.getInstance().getDAOCategorie();
	                Categorie categorie = DAOcategorie.findByName(values[i].trim());
	                if (categorie == null) {
	                    categorie = new Categorie();
	                    categorie.setNom(values[i].trim());
	                    DAOcategorie.create(categorie);
	                }
	                produit.setCategory(categorie);		
					
					 
					break;
				case 1:
					DAOMarque DAOmarque = DAOFactory.getInstance().getDAOMarque();
	                String[] marquesTab = values[i].trim().split(",");
	                for (String m : marquesTab) {
	                	
	                	Marque marque = DAOmarque.findByNom(m);
		                if (marque == null) {
		                    marque = new Marque();
		                    marque.setNom(m);
		                    DAOmarque.create(marque);
		                }
		                produit.getMarques().add(marque);
					}
	                
	                break;
				case 2:
					produit.setName(values[i].trim());
					break;
				case 3:
					produit.setNutri(Nutri.valueOf(values[i].trim().toUpperCase()));
					break;
				case 4:
					DAOIngredient DAOingredient = DAOFactory.getInstance().getDAOIngredient();
	                String[] ingredientsTab = values[i].trim().replaceAll("[%_()\\*]", "").split(",");
	                for (String ing : ingredientsTab) {
	                	
	                	Ingredient ingredient = DAOingredient.findByName(ing);
		                if (ingredient == null) {
		                	ingredient = new Ingredient();
		                	ingredient.setNom(ing);
		                	DAOingredient.create(ingredient);
		                }
		                produit.getIngredients().add(ingredient);
					}
					
					break;
				case 5:
					try {
						produit.setEnergy(Float.parseFloat(values[i].trim()));
					} catch (NumberFormatException e) {
					}
					
					break;
				case 6:
					produit.setGraisse(Float.valueOf(values[i].trim()));
					break;
				case 7:
					produit.setSucres(Float.valueOf(values[i].trim()));
					break;
				case 8:
					produit.setFibres(Float.valueOf(values[i].trim()));
					break;
				case 9:
					produit.setProteines(Float.valueOf(values[i].trim()));
					break;
				case 10:
					produit.setSel(Double.valueOf(values[i].trim()));
					break;
				case 11:
					produit.setVitA(Double.valueOf(values[i].trim()));
					break;
				case 12:
					produit.setVitD(Double.valueOf(values[i].trim()));
					break;
				case 13:
					produit.setVitE(Double.valueOf(values[i].trim()));
					break;
				case 14:
					produit.setVitK(Double.valueOf(values[i].trim()));
					break;
				case 15:
					produit.setVitC(Double.valueOf(values[i].trim()));
					break;
				case 16:
					produit.setVitB1(Double.valueOf(values[i].trim()));
					break;
				case 17:
					produit.setVitB2(Double.valueOf(values[i].trim()));
					break;
				case 18:
					produit.setVitPP(Double.valueOf(values[i].trim()));
					break;
				case 19:
					produit.setVitB6(Double.valueOf(values[i].trim()));
					break;
				case 20:
					produit.setVitB9(Double.valueOf(values[i].trim()));
					break;
				case 21:
					produit.setVitB12(Double.valueOf(values[i].trim()));
					break;
				case 22:
					produit.setCalcium(Double.valueOf(values[i].trim()));
					break;
				case 23:
					produit.setMagnesium(Double.valueOf(values[i].trim()));
					break;
				case 24:
					produit.setIron(Double.valueOf(values[i].trim()));
					break;
				case 25:
					produit.setFer(Double.valueOf(values[i].trim()));
					break;
				case 26:
					produit.setBetaCarotene(Double.valueOf(values[i].trim()));
					break;
				case 27:
					produit.setPresenceHuilePalme(Boolean.valueOf(values[i].trim()));
					break;
				case 28: 
					DAOAllergene DAOallergene = DAOFactory.getInstance().getDAOAllergene();
	                String[] allergeneTab = values[i].trim().split(",");
	                for (String all : allergeneTab) {
	                	
	                	Allergene allergene = DAOallergene.findByName(all);
		                if (allergene == null) {
		                	allergene = new Allergene();
		                	allergene.setNom(all);
		                	DAOallergene.create(allergene);
		                }
		                produit.getAllergenes().add(allergene);
					}
					break;
				case 29: 
					DAOAdditif DAOadditif = DAOFactory.getInstance().getDAOAdditif();
	                String[] additifTab = values[i].trim().split(",");
	                for (String addit : additifTab) {
	                	String code = addit.substring(0,addit.indexOf(" "));
	                	String nom = addit.substring(addit.indexOf("-")+ 1).trim();       	
	                	Additif additif = DAOadditif.findByCode(code);
	               
		                if (additif == null ) {
		                	additif = new Additif();
		                	additif.setNom(nom);
		                	additif.setCode(code);
		                	DAOadditif.create(additif);
		                }

		                produit.getAdditifs().add(additif);
					}
	                

					break;

				default:
					break;
				}
            	
            }
                 
            DAOFactory.getInstance().getDAOProduit().create(produit);
        	count++;
        	if(count == 5000) {
        		break;
        	}

            
            
		} 
		long fin = System.currentTimeMillis();
		
        System.out.println("Temps ecoule en millisecondes : " + (fin - debut));
		System.out.println("Temps ecoule en minutes : " + (fin - debut)/60000);
		
		
	}

}
