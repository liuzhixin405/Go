package model

type AssetTransferRecord struct {
	Dto
	CstomerId string
	CoiId     string
	Direction int
	Amount    float64
	Status    int
	inessId   string
}
