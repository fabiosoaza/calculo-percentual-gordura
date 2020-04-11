package com.example.calculo.percentual.gordura.calculadora

import android.os.Parcel
import android.os.Parcelable
import java.math.BigDecimal

data class DadosCalculo(var sexo:Sexo, var numeroDobrasCutaneas:Int, var idade:Int, var peso:BigDecimal, var medidaTriceps:BigDecimal, var medidaSubscapular:BigDecimal, var medidaAbnominal:BigDecimal, var mediadaSupraIliaca:BigDecimal, var medidaCoxa:BigDecimal) : Parcelable {
    constructor(parcel: Parcel) : this(
        Sexo.criar(parcel.readInt()),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readSerializable() as BigDecimal,
        parcel.readSerializable() as BigDecimal,
        parcel.readSerializable() as BigDecimal,
        parcel.readSerializable() as BigDecimal,
        parcel.readSerializable() as BigDecimal,
        parcel.readSerializable() as BigDecimal
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(sexo.codigo)
        parcel.writeInt(numeroDobrasCutaneas)
        parcel.writeInt(idade)
        parcel.writeSerializable(peso)
        parcel.writeSerializable(medidaTriceps)
        parcel.writeSerializable(medidaSubscapular)
        parcel.writeSerializable(medidaAbnominal)
        parcel.writeSerializable(mediadaSupraIliaca)
        parcel.writeSerializable(medidaCoxa)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<DadosCalculo> {
        override fun createFromParcel(parcel: Parcel): DadosCalculo {
            return DadosCalculo(parcel)
        }

        override fun newArray(size: Int): Array<DadosCalculo?> {
            return arrayOfNulls(size)
        }
    }


}