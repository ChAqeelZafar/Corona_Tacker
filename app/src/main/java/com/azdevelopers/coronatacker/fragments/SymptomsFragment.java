package com.azdevelopers.coronatacker.fragments;

import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.azdevelopers.coronatacker.FragmentContainerActivity;
import com.azdevelopers.coronatacker.R;

public class SymptomsFragment extends Fragment {

    //TextView for Symptoms data display
    private TextView mainTextView;
    //TextButton at upper and bottom to switch bw fragments
    private TextView casesText, countryText, updatesText, symptomsText;
    private TextView casesTextB, countryTextB, updatesTextB, symptomsTextB;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_symptoms, container, false);

        bindIds(view);
        setListeners();

        ((FragmentContainerActivity) getActivity()).setCurrentFragment("symptoms");

        setTextView();

        return view;
    }

    public void setListeners(){
        symptomsText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new SymptomsFragment());
            }
        });
        symptomsTextB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new SymptomsFragment());
            }
        });

        countryText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new CountriesFragment());
            }
        });

        countryTextB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new CountriesFragment());
            }
        });


        updatesText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new NewsFragment());
            }
        });
        updatesTextB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new NewsFragment());
            }
        });

        casesText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new MainFragment());
            }
        });
        casesTextB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new MainFragment());
            }
        });
    }


    public void bindIds(View view){
        mainTextView = view.findViewById(R.id.symptoms_text_main);

        casesText = view.findViewById(R.id.symptoms_textbtn_cases);
        countryText = view.findViewById(R.id.symptoms_textbtn_country);
        updatesText = view.findViewById(R.id.symptoms_textbtn_updates);
        symptomsText = view.findViewById(R.id.symptoms_textbtn_symptoms);


        casesTextB = view.findViewById(R.id.symptoms_textbtn_bottom_cases);
        countryTextB = view.findViewById(R.id.symptoms_textbtn_bottom_country);
        updatesTextB = view.findViewById(R.id.symptoms_textbtn_bottom_updates);
        symptomsTextB = view.findViewById(R.id.symptoms_textbtn_bottom_symptoms);

    }

    private void loadFragment(Fragment fragment){
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.temp_fragment_container, fragment);
        fragmentTransaction.commit();

    }

    public void setTextView(){


        String temp = "<div class=\"col-md-8\">\n" +
                "    <h1 id=\"page-top\">Coronavirus Symptoms (COVID-19) </h1>\n" +
                "    <div style=\"color:#999\">\n" +
                "\n" +
                "        <p>Reported illnesses have ranged from people with mild symptoms to people being severely ill and dying. </p>\n" +
                "        <p>Symptoms can include: </p>\n" +
                "        <ul>\n" +
                "            <li>Fever </li>\n" +
                "            <li>Cough</li>\n" +
                "            <li>Shortness of breath </li>\n" +
                "        </ul>\n" +
                "\t\t<br>\n" +
                "        <div style=\"margin-top:50px\" class=\"spaced\"> <strong>Content: </strong>\n" +
                "            <ul>\n" +
                " \n" +
                "                <li><strong>Typical Symptoms</strong></li>\n" +
                "                <li><strong>80% of cases are mild </strong></li>\n" +
                "                <li><strong>Pre-existing conditions</strong></li>\n" +
                "                <li><strong>Examples of possible development of symptoms</strong></li>\n" +
                "                <li><strong>How long do symptoms last? </strong>(duration from onset to recovery)</li>\n" +
                "                <li><strong>Symptoms observed in hospitalized patients</strong></li>\n" +
                "                <li>Information on Coronavirus Symptoms from Government Health Officials</li>\n" +
                "            </ul>\n" +
                "        </div>\n" +
                "\t\t<br>\n" +
                "\t\t<br>\n" +
                "        <h2 id=\"typical\">Typical Symptoms</h2>\n" +
                "        <p>COVID-19 typically causes flu-like symptoms including a fever and cough. </p>\n" +
                "        <p>In some patients - particularly the elderly and others with other chronic health conditions - these symptoms can develop into pneumonia, with chest tightness, chest pain, and shortness of breath.</p>\n" +
                "        <p> It seems to <strong>start with a fever</strong>, <strong>followed by a dry cough</strong>.</p>\n" +
                "        <p><strong>After a week, it can lead to shortness of breath,</strong> with about 20% of patients requiring hospital treatment.\n" +
                "            <br>\n" +
                "            <br>Notably, the COVID-19 infection<strong> rarely seems to cause a runny nose</strong>, sneezing, or sore throat (these symptoms have been observed in only about 5% of patients). <strong>Sore throat, sneezing, and stuffy nose are most often signs of a cold</strong>.</p>\n" +
                "\n" +
                "\t\t<br>\n" +
                "\t\t<br>\n" +
                "        <h2 id=\"mild\">80% of cases are mild </h2>\n" +
                "        <p>Based on all 72,314 cases of COVID-19 confirmed, suspected, and asymptomatic cases in China as of February 11, a paper by the Chinese CCDC released on February 17 and published in the Chinese Journal of Epidemiology has found that:</p>\n" +
                "        <ul class=\"story-body__unordered-list\">\n" +
                "            <li class=\"story-body__list-item\"><strong>80.9% of infections are mild</strong> (with flu-like symptoms) and <strong>can recover at home</strong>.</li>\n" +
                "            <li class=\"story-body__list-item\"><strong>13.8% are severe</strong>, developing severe diseases including <strong>pneumonia </strong>and <strong>shortness of breath</strong>.</li>\n" +
                "            <li class=\"story-body__list-item\"> <strong>4.7% as critical </strong>and can include: <strong>respiratory failure</strong>, <strong>septic shock</strong>, and <strong>multi-organ failure</strong>.</li>\n" +
                "            <li class=\"story-body__list-item\">in about 2% of reported cases the virus is fatal.</li>\n" +
                "            <li class=\"story-body__list-item\"> Risk of death increases the older you are.</li>\n" +
                "            <li class=\"story-body__list-item\">Relatively few cases are seen among children.</li>\n" +
                "        </ul>\n" +
                "\n" +
                "\t\t<br>\n" +
                "        <h2 id=\"pre\">Pre-existing conditions</h2>\n" +
                "        \n" +
                "        <p><span class=\"story-body__list-item\">Pre-existing illnesses that put patients at higher risk: </span></p>\n" +
                "        <ol>\n" +
                "            <li><span class=\"story-body__list-item\">cardiovascular disease</span></li>\n" +
                "            <li><span class=\"story-body__list-item\">diabetes</span></li>\n" +
                "            <li><span class=\"story-body__list-item\">chronic respiratory disease</span></li>\n" +
                "            <li><span class=\"story-body__list-item\">hypertension</span></li>\n" +
                "        </ol>\n" +
                "        <p>That said, some otherwise healthy people do seem to develop a severe form of pneumonia after being infected by the virus. The reason for this is being investigated as we try to learn more about this new virus.</p>\n" +
                "\n" +
                "\t\t<br><br>\n" +
                "        <h2 id=\"examples\">Examples of possible development of symptoms (from actual cases) </h2>\n" +
                "        <p>A man in his 40s in Japan:</p>\n" +
                "        <ul>\n" +
                "            <li><strong>Day #1: <strong></strong></strong><strong></strong><strong>malaise and muscle pain</strong></li>\n" +
                "            <li> later diagnosed with pneumonia</li>\n" +
                "        </ul>\n" +
                "        <p>A man in his 60s in Japan:</p>\n" +
                "        <ul>\n" +
                "            <li><strong>Day #1: <strong></strong></strong><strong></strong>initial symptoms of <strong>low-grade fever and sore throat</strong>.</li>\n" +
                "        </ul>\n" +
                "        <p>A man in his 40s in Japan:</p>\n" +
                "        <ul>\n" +
                "            <li><strong>Day #1: <strong></strong></strong><strong>chills</strong>, <strong>sweating</strong> and <strong>malaise</strong></li>\n" +
                "            <li><strong>Day #4: <strong></strong></strong><strong>fever</strong>, <strong>muscle pain</strong> and <strong>cough</strong></li>\n" +
                "        </ul>\n" +
                "        <p>A woman in her 70s, in Japan:</p>\n" +
                "        <ul>\n" +
                "            <li><strong>Day #1: <strong></strong></strong><strong>38° fever for a few minutes</strong></li>\n" +
                "            <li><strong>Day #2-3: </strong>went on a bus tour</li>\n" +
                "            <li><strong>Day #5: visited a medical institution</strong></li>\n" +
                "            <li><strong>Day #6: showed symptoms of pneumonia</strong>. </li>\n" +
                "        </ul>\n" +
                "        <p>A woman in her 40s, in Japan:</p>\n" +
                "        <ul>\n" +
                "            <li><strong>Day #1: <strong></strong>low-grade fever</strong>\n" +
                "            </li>\n" +
                "            <li> Day #2: 38<strong>°</strong> fever</li>\n" +
                "            <li> Day #6: being <strong>treated at home</strong>.</li>\n" +
                "        </ul>\n" +
                "        <p>A man in his 60s, in Japan: </p>\n" +
                "        <ul>\n" +
                "            <li>Day #1: <strong>Cold</strong></li>\n" +
                "            <li>Day #6: <strong>Fever of 39° C.</strong> (102.2 F) </li>\n" +
                "            <li>Day #8: <strong>Pneumonia</strong></li>\n" +
                "        </ul>\n" +
                "        <p>Another patient, in China with a history of type 2 diabetes and hypertension:</p>\n" +
                "        <ul>\n" +
                "            <li><strong>Jan. 22: Fever and cough</strong></li>\n" +
                "            <li>Feb. 5: Died </li>\n" +
                "        </ul>\n" +
                "        <p>First death in the Philippines (a 44-year-old Chinese thought to have had other pre-existing health conditions):</p>\n" +
                "        <ul>\n" +
                "            <li>Jan. 25: <strong>Fever, cough, and sore throat (hospitalized) </strong></li>\n" +
                "            <li>Developed <strong>severe pneumonia</strong></li>\n" +
                "            <li>Feb. 2: Died</li>\n" +
                "        </ul>\n" +
                "\n" +
                "        <h2 id=\"hospitalized\">&nbsp;</h2>\n" +
                "        <h2 id=\"duration\">How long do symptoms last?</h2>\n" +
                "        <p>Using available preliminary data, the Report of the WHO-China Joint Mission published on Feb. 28 by WHO,  which is based on 55,924 laboratory confirmed cases, observed the following median time from symptoms onset to clinical recovery:</p>\n" +
                "        <ul>\n" +
                "            <li><strong>mild cases</strong>: approximately <strong>2 weeks</strong></li>\n" +
                "            <li><strong>severe or critical</strong> disease:<strong> 3 - 6 weeks</strong> </li>\n" +
                "            <li>time from onset to the development of severe disease (including hypoxia):<strong> 1 week</strong></li>\n" +
                "        </ul>\n" +
                "        <p>Among patients who have died, the time from symptom onset to outcome ranges from 2 - 8 weeks.</p>\n" +
                "\n" +
                "<br>\n" +
                "<br>\n" +
                "        <h2>Symptoms observed in hospitalized patients with COVID-19</h2>Below we list the symptoms, with <strong>percentages representing the proportion of patients displaying that symptom</strong>, as observed in hospitalized patients tested and identified as having laboratory-confirmed COVID-19 infection. These findings refer to <strong>hospitalized patients</strong>, therefore generally representing <strong>serious</strong> or critical cases. The <strong>majority of cases of COVID-19 (about 80%) is mild</strong>.\n" +
                "        <br>\n" +
                "\t\t<h3>Findings from the Wang et al study published on JAMA and based on 138 hospitalized patients </h3>\n" +
                "        <div class=\"table-responsive\" style=\"max-width:350px\">\n" +
                "            <table class=\"table table-hover table-bordered table-condensed table-list\">\n" +
                "                <thead>\n" +
                "                    <tr bgcolor=\"#FCF8F8\">\n" +
                "                        <td height=\"35\" colspan=\"2\">\n" +
                "                            <div align=\"left\"><strong>Common symptoms included: </strong>\n" +
                "                                <br> (Wang et al study) </div>\n" +
                "                            <div align=\"right\"></div>\n" +
                "                        </td>\n" +
                "                    </tr>\n" +
                "                </thead>\n" +
                "                <tbody>\n" +
                "                    <tr class=\"scrollable bordered\">\n" +
                "                        <td width=\"287\">\n" +
                "                            <div align=\"left\"><strong>Fever</strong></div>\n" +
                "                        </td>\n" +
                "                        <td width=\"82\">\n" +
                "                            <div align=\"right\">98.6%</div>\n" +
                "                        </td>\n" +
                "                    </tr>\n" +
                "                    <tr class=\"scrollable bordered\">\n" +
                "                        <td>\n" +
                "                            <div align=\"left\"><strong>Fatigue</strong></div>\n" +
                "                        </td>\n" +
                "                        <td>\n" +
                "                            <div align=\"right\">69.6%</div>\n" +
                "                        </td>\n" +
                "                    </tr>\n" +
                "                    <tr class=\"scrollable bordered\">\n" +
                "                        <td>\n" +
                "                            <div align=\"left\"><strong>Dry cough</strong></div>\n" +
                "                        </td>\n" +
                "                        <td>\n" +
                "                            <div align=\"right\">59.4%</div>\n" +
                "                        </td>\n" +
                "                    </tr>\n" +
                "                </tbody>\n" +
                "            </table>\n" +
                "        </div>\n" +
                "        <p><span>The median time observed:</span></p>\n" +
                "        <ul>\n" +
                "            <li><span>from <strong>first symptom</strong> to → <strong>Dyspnea</strong> (Shortness of breath) = <strong>5.0 days</strong></span></li>\n" +
                "            <li><span><span>from <strong>first symptom</strong></span> to <span>→ </span> <strong>Hospital admission</strong> = <strong>7.0 days</strong></span>\n" +
                "            </li>\n" +
                "            <li><span> <span><span>from <strong>first symptom</strong></span> to <span>→ </span> <strong>ARDS </strong>(Acute Respiratory Distress Syndrome) = </span> <strong>8.0 days </strong>(when occurring) </span>\n" +
                "            </li>\n" +
                "        </ul>\n" +
                "        <br>\n" +
                "        \n" +
                "        <p>\n" +
                "           <br>\n" +
                "          <h3>Findings from the Huang et al study published on The Lancet and based on 41 hospitalized patients </h3>\n" +
                "        <div class=\"table-responsive\" style=\"max-width:350px\">\n" +
                "            <table class=\"table table-hover table-bordered table-condensed table-list\">\n" +
                "                <thead>\n" +
                "                    <tr bgcolor=\"#FCF8F8\">\n" +
                "                        <td height=\"35\" colspan=\"2\">\n" +
                "                            <div align=\"left\">COMMON SYMPTOMS\n" +
                "                                <br> AT ONSET OF ILLNESS\n" +
                "                                <br> (Huang et al study) </div>\n" +
                "                            <div align=\"right\"></div>\n" +
                "                        </td>\n" +
                "                    </tr>\n" +
                "                </thead>\n" +
                "                <tbody>\n" +
                "                    <tr class=\"scrollable bordered\">\n" +
                "                        <td width=\"287\">\n" +
                "                            <div align=\"left\"><strong>Fever</strong></div>\n" +
                "                        </td>\n" +
                "                        <td width=\"82\">\n" +
                "                            <div align=\"right\">98%</div>\n" +
                "                        </td>\n" +
                "                    </tr>\n" +
                "                    <tr class=\"scrollable bordered\">\n" +
                "                        <td>\n" +
                "                            <div align=\"left\"><strong>Cough</strong></div>\n" +
                "                        </td>\n" +
                "                        <td>\n" +
                "                            <div align=\"right\">76%</div>\n" +
                "                        </td>\n" +
                "                    </tr>\n" +
                "                    <tr class=\"scrollable bordered\">\n" +
                "                        <td>\n" +
                "                            <div align=\"left\"><strong>Myalgia </strong>(muscle pain) <strong><br> or Fatigue</strong></div>\n" +
                "                        </td>\n" +
                "                        <td>\n" +
                "                            <div align=\"right\">44%</div>\n" +
                "                        </td>\n" +
                "                    </tr>\n" +
                "                    <tr class=\"scrollable bordered\" bgcolor=\"#FCF8F8\">\n" +
                "                        <td height=\"37\" colspan=\"2\">\n" +
                "                            <div align=\"left\">LESS COMMON SYMPTOMS: </div>\n" +
                "                            <div align=\"right\"></div>\n" +
                "                        </td>\n" +
                "                    </tr>\n" +
                "                    <tr class=\"scrollable bordered\">\n" +
                "                        <td>\n" +
                "                            <div align=\"left\"><strong>Sputum production </strong>\n" +
                "                                <br> (coughing up material<span class=\"ILfuVd\"><span class=\"e24Kjd\">)</span></span>\n" +
                "                            </div>\n" +
                "                        </td>\n" +
                "                        <td>\n" +
                "                            <div align=\"right\">28%</div>\n" +
                "                        </td>\n" +
                "                    </tr>\n" +
                "                    <tr class=\"scrollable bordered\">\n" +
                "                        <td>\n" +
                "                            <div align=\"left\"><strong>Headache</strong></div>\n" +
                "                        </td>\n" +
                "                        <td>\n" +
                "                            <div align=\"right\">8%</div>\n" +
                "                        </td>\n" +
                "                    </tr>\n" +
                "                    <tr class=\"scrollable bordered\">\n" +
                "                        <td>\n" +
                "                            <div align=\"left\"><strong>Haemoptysis<br> </strong>(coughing up blood) </div>\n" +
                "                        </td>\n" +
                "                        <td>\n" +
                "                            <div align=\"right\">5%</div>\n" +
                "                        </td>\n" +
                "                    </tr>\n" +
                "                    <tr class=\"scrollable bordered\">\n" +
                "                        <td>\n" +
                "                            <div align=\"left\"><strong>Diarrhea</strong></div>\n" +
                "                        </td>\n" +
                "                        <td>\n" +
                "                            <div align=\"right\">3%</div>\n" +
                "                        </td>\n" +
                "                    </tr>\n" +
                "                </tbody>\n" +
                "            </table>\n" +
                "        </div>\n" +
                "\t\t<br>\n" +
                "        <h3>Findings from the Chen et al study published on The Lancet and based on 99 hospitalized patients </h3>\n" +
                "        <div class=\"table-responsive\" style=\"max-width:350px\">\n" +
                "            <table class=\"table table-hover table-bordered table-condensed table-list\">\n" +
                "                <thead>\n" +
                "                    <tr bgcolor=\"#FCF8F8\">\n" +
                "                        <td height=\"35\" colspan=\"3\">\n" +
                "                            <div align=\"left\"><strong>Signs and symptoms at admission</strong>\n" +
                "                                <br> (Chen et al study)</div>\n" +
                "                            <div align=\"right\"></div>\n" +
                "                        </td>\n" +
                "                    </tr>\n" +
                "                </thead>\n" +
                "                <tbody>\n" +
                "                    <tr class=\"scrollable bordered\">\n" +
                "                        <td colspan=\"2\">\n" +
                "                            <div align=\"left\"><strong>Fever</strong></div>\n" +
                "                        </td>\n" +
                "                        <td width=\"52\">\n" +
                "                            <div align=\"right\">83%</div>\n" +
                "                        </td>\n" +
                "                    </tr>\n" +
                "                    <tr class=\"scrollable bordered\">\n" +
                "                        <td colspan=\"2\">\n" +
                "                            <div align=\"left\"><strong>Cough</strong></div>\n" +
                "                        </td>\n" +
                "                        <td>\n" +
                "                            <div align=\"right\">82%</div>\n" +
                "                        </td>\n" +
                "                    </tr>\n" +
                "                    <tr class=\"scrollable bordered\">\n" +
                "                        <td colspan=\"2\">\n" +
                "                            <div align=\"left\"><strong>Shortness of breath</strong></div>\n" +
                "                        </td>\n" +
                "                        <td>\n" +
                "                            <div align=\"right\">31%</div>\n" +
                "                        </td>\n" +
                "                    </tr>\n" +
                "                    <tr class=\"scrollable bordered\">\n" +
                "                        <td colspan=\"2\">\n" +
                "                            <div align=\"left\"><strong>Muscle ache</strong></div>\n" +
                "                        </td>\n" +
                "                        <td>\n" +
                "                            <div align=\"right\">11%</div>\n" +
                "                        </td>\n" +
                "                    </tr>\n" +
                "                    <tr class=\"scrollable bordered\">\n" +
                "                        <td colspan=\"2\">\n" +
                "                            <div align=\"left\"><strong>Confusion</strong></div>\n" +
                "                        </td>\n" +
                "                        <td>\n" +
                "                            <div align=\"right\">9%</div>\n" +
                "                        </td>\n" +
                "                    </tr>\n" +
                "                    <tr class=\"scrollable bordered\">\n" +
                "                        <td colspan=\"2\">\n" +
                "                            <div align=\"left\"><strong>Headache</strong></div>\n" +
                "                        </td>\n" +
                "                        <td>\n" +
                "                            <div align=\"right\">8%</div>\n" +
                "                        </td>\n" +
                "                    </tr>\n" +
                "                    <tr class=\"scrollable bordered\">\n" +
                "                        <td colspan=\"2\">\n" +
                "                            <div align=\"left\"><strong>Sore throat</strong></div>\n" +
                "                        </td>\n" +
                "                        <td>\n" +
                "                            <div align=\"right\">5%</div>\n" +
                "                        </td>\n" +
                "                    </tr>\n" +
                "                    <tr class=\"scrollable bordered\">\n" +
                "                        <td colspan=\"2\">\n" +
                "                            <div align=\"left\"><strong>Rhinorrhoea (runny nose) </strong></div>\n" +
                "                        </td>\n" +
                "                        <td>\n" +
                "                            <div align=\"right\">4%</div>\n" +
                "                        </td>\n" +
                "                    </tr>\n" +
                "                    <tr class=\"scrollable bordered\">\n" +
                "                        <td colspan=\"2\">\n" +
                "                            <div align=\"left\"><strong>Chest pain</strong></div>\n" +
                "                        </td>\n" +
                "                        <td>\n" +
                "                            <div align=\"right\">2%</div>\n" +
                "                        </td>\n" +
                "                    </tr>\n" +
                "                    <tr class=\"scrollable bordered\">\n" +
                "                        <td colspan=\"2\">\n" +
                "                            <div align=\"left\"><strong>Diarrhea</strong></div>\n" +
                "                        </td>\n" +
                "                        <td>\n" +
                "                            <div align=\"right\">2%</div>\n" +
                "                        </td>\n" +
                "                    </tr>\n" +
                "                    <tr class=\"scrollable bordered\">\n" +
                "                        <td colspan=\"2\">\n" +
                "                            <div align=\"left\"><strong>Nausea and vomiting</strong></div>\n" +
                "                        </td>\n" +
                "                        <td>\n" +
                "                            <div align=\"right\">1%</div>\n" +
                "                        </td>\n" +
                "                    </tr>\n" +
                "                    <tr bgcolor=\"#F0F0F0\" class=\"scrollable bordered\">\n" +
                "                        <td colspan=\"2\">\n" +
                "                            <div align=\"left\"><strong>More than one sign <br> or symptom</strong></div>\n" +
                "                        </td>\n" +
                "                        <td>\n" +
                "                            <div align=\"right\"><strong>90%</strong></div>\n" +
                "                        </td>\n" +
                "                    </tr>\n" +
                "                    <tr bgcolor=\"#F2F2F2\">\n" +
                "                        <td width=\"76\">\n" +
                "                            <div align=\"left\"></div>\n" +
                "                        </td>\n" +
                "                        <td width=\"130\" bgcolor=\"#F8F8F8\" class=\"scrollable bordered\">\n" +
                "                            <div align=\"left\"><strong>Fever, cough, <br> and shortness <br> of breath</strong></div>\n" +
                "                        </td>\n" +
                "                        <td bgcolor=\"#F8F8F8\" class=\"scrollable bordered\">\n" +
                "                            <div align=\"right\">15%</div>\n" +
                "                        </td>\n" +
                "                    </tr>\n" +
                "                </tbody>\n" +
                "            </table>\n" +
                "        </div>\n" +
                "\n" +
                "<br>\n" +
                "<br>\n" +
                "        <h3 id=\"info\">Information on Coronavirus Symptoms from Government Health Officials </h3>\n" +
                "        <h4>Canada Public Health Agency</h4>\n" +
                "\n" +
                "        <ul>\n" +
                "            <li> You may have little to no symptoms.</li>\n" +
                "            <li>You may not know you have symptoms of COVID-19 because they are <strong>similar to a cold or flu</strong>.</li>\n" +
                "            <li>Symptoms may take up to 14 days to appear after exposure to the virus. This is the longest known infectious period for this virus.</li>\n" +
                "        </ul>\n" +
                "        <p>Symptoms have included:</p>\n" +
                "        <ul>\n" +
                "            <li><strong>fever</strong></li>\n" +
                "            <li><strong>cough</strong></li>\n" +
                "            <li><strong>difficulty breathing</strong></li>\n" +
                "            <li><strong>pneumonia in both lungs</strong></li>\n" +
                "        </ul>\n" +
                "        <p>In severe cases, infection can lead to death.</p>\n" +
                "\t\t<br>\n" +
                "\t\t<br>\n" +
                "        <h4>UK Government and NHS </h4>\n" +
                "        <p>The UK National Health Service (NHS) section dedicated to Coronavirus (2019-nCoV) lists the following as the main symptoms of coronavirus:</p>\n" +
                "        <ul>\n" +
                "            <li><strong>a cough</strong></li>\n" +
                "            <li><strong>a high temperature</strong></li>\n" +
                "            <li><strong>shortness of breath</strong></li>\n" +
                "        </ul>\n" +
                "        <p>\n" +
                "            <br>The GOV.UK novel coronavirus guidance for the public page says:</p>\n" +
                "        <ul>\n" +
                "            <li>Typical symptoms of coronavirus include <strong>fever</strong> and a <strong>cough that may progress to a severe pneumonia</strong> <strong>causing shortness of breath </strong>and breathing difficulties.</li>\n" +
                "        </ul>\n" +
                "        <p>\n" +
                "            <br>The GOV.UK clinical guidance on Novel coronavirus (2019-nCoV): epidemiology, virology and clinical features notes that:</p>\n" +
                "        <ul>\n" +
                "            <li><strong>Fever</strong>, <strong>cough</strong> or <strong>chest tightness</strong>, and <strong>dyspnoea</strong> are the main symptoms reported. While most cases report a mild illness, severe are also being reported, some of whom require intensive care.\n" +
                "                <br> </li>\n" +
                "        </ul>\n" +
                "\t\t<br>\n" +
                "\t\t<br>\n" +
                "        <h4>Australian Government</h4>\n" +
                "        <p>The Australian Government Department of Health informs that symptoms can range from mild illness to pneumonia, adding that some people will recover easily, while others may get very sick very quickly. According to their list of novel coronavirus symptoms, people may experience:</p>\n" +
                "        <ul>\n" +
                "            <li><strong>fever</strong></li>\n" +
                "            <li><strong>flu-like symptoms such as coughing, sore throat and fatigue</strong></li>\n" +
                "            <li><strong>shortness of breath<br> </strong></li>\n" +
                "        </ul>\n" +
                "        <br>\n" +
                "        <h4>United States Centers for Disease Control and Prevention </h4>\n" +
                "        <p>The CDC has published the following infographic on its Symptoms of Novel Coronavirus (2019-nCoV):</p>\n" +
                "\t\t<br>\n" +
                "\t\t<br>\n" +
                "        <h4>World Health Organization </h4>\n" +
                "        <p> The WHO has issued an interim guidance on the clinical management of suspected cases in which it says that </p>\n" +
                "        <ul>\n" +
                "            <li>\"nCoV may present with <strong>mild</strong>, <strong>moderate</strong>, or <strong>severe</strong> illness; the latter includes severe pneumonia, ARDS, sepsis and septic shock.\"</li>\n" +
                "        </ul>\n" +
                "\n" +
                "    </div>";
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            mainTextView.setText(Html.fromHtml(temp, Html.FROM_HTML_MODE_COMPACT));
        } else {
            mainTextView.setText(Html.fromHtml(temp));
        }
    }


}
