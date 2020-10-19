package com.nicoqueijo.celero.util

object Utils {
    /**
     * Notes:
     * -This could also be changed to use a map for performance reasons.
     * -This only assumes addresses are all within Unites States.
     *  Might not work with international addresses and Washington DC, for example.
     */
    @JvmStatic
    fun getAbbreviatedState(state: String): String {
        return when (state) {
            "Alabama" -> "AL"
            "Alaska" -> "AK"
            "Arizona" -> "AZ"
            "Arkansas" -> "AR"
            "California" -> "CA"
            "Colorado" -> "CO"
            "Connecticut" -> "CT"
            "Delaware" -> "DE"
            "Florida" -> "FL"
            "Georgia" -> "GA"
            "Hawaii" -> "HI"
            "Idaho" -> "ID"
            "Illinois" -> "IL"
            "Indiana" -> "IN"
            "Iowa" -> "IA"
            "Kansas" -> "KS"
            "Kentucky" -> "KY"
            "Louisiana" -> "LA"
            "Maine" -> "ME"
            "Maryland" -> "MD"
            "Massachusetts" -> "MA"
            "Michigan" -> "MI"
            "Minnesota" -> "MN"
            "Mississippi" -> "MS"
            "Missouri" -> "MO"
            "Montana" -> "MT"
            "Nebraska" -> "NE"
            "Nevada" -> "NV"
            "New Hampshire" -> "NH"
            "New Jersey" -> "NJ"
            "New Mexico" -> "NM"
            "New York" -> "NY"
            "North Carolina" -> "NC"
            "North Dakota" -> "ND"
            "Ohio" -> "OH"
            "Oklahoma" -> "OK"
            "Oregon" -> "OR"
            "Pennsylvania" -> "PA"
            "Rhode Island" -> "RI"
            "South Carolina" -> "SC"
            "South Dakota" -> "SD"
            "Tennessee" -> "TN"
            "Texas" -> "TX"
            "Utah" -> "UT"
            "Vermont" -> "VT"
            "Virginia" -> "VA"
            "Washington" -> "WA"
            "West Virginia" -> "WV"
            "Wisconsin" -> "WI"
            "Wyoming" -> "WY"
            else -> ""
        }
    }
}