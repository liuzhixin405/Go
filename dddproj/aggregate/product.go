package aggregate

import (
	"dddproj/entity"
	"errors"
	"github.com/google/uuid"
)

type Product struct {
	item     *entity.Item
	price    float64
	quantity int
}

var (
	ErrMissingValues = errors.New("missint important value")
)

func NewProduct(name, description string, price float64) (Product, error) {
	if name == "" || description == "" {
		return Product{}, ErrMissingValues
	}
	return Product{
		item: &entity.Item{
			ID:          uuid.New(),
			Name:        name,
			Description: description,
		},
		price:    price,
		quantity: 0,
	}, nil
}
func (p Product) GetID() uuid.UUID {
	return p.item.ID
}

func (p Product) GetItem() *entity.Item {
	return p.item
}

func (p Product) GetPrice() float64 {
	return p.price
}
